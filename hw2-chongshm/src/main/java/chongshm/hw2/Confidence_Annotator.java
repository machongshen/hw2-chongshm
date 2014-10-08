package chongshm.hw2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import abner.*;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import edu.cmu.deiis.types.Annotation;
import edu.cmu.deiis.types.Consumer;
import edu.cmu.deiis.types.Token;
import edu.cmu.hw2chongshm.consumers;
import edu.cmu.hw2chongshm.types;
/**
 * Description: Confidence_Annotator is responsible for comparing the results from the two previous annotators,
 *  the Lingpipe(RunChunker_Annotator) and Abner (Abner_Annotator). This annotator could choose the more 
 *  trustworthy results from the different annotators.   
 * @author machongshen
 * 
 * 
 */
public class Confidence_Annotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub

		FSIterator it = aJCas
				.getAnnotationIndex(edu.cmu.deiis.types.Annotation.type).iterator();
		Map<String, Annotation> mapLingpipe = new HashMap<String, Annotation>();
		Map<String, Annotation> mapAbner = new HashMap<String, Annotation>();
		Map<String, Double> mapcompare = new HashMap<String, Double>();

		while (it.hasNext()) {
			Annotation annotation = (Annotation) it.next();
			String start = Integer.toString(annotation.getStart());
			if (annotation.getCasProcessorId() == "Lingpipe") {
				mapLingpipe.put(start, annotation);
			} else
				mapAbner.put(start, annotation);

		}
		
		Iterator lingpipe = mapLingpipe.entrySet().iterator();

		while (lingpipe.hasNext()) {
			Map.Entry<String, Annotation> entry = (Entry<String, Annotation>) lingpipe
					.next();

			if (!mapcompare.containsKey(entry.getValue().getGene_Mark())&&entry.getValue().getConfidence() >= 0.6
					|| Match(entry.getKey(), mapAbner)) {
				Consumer token = new Consumer(aJCas);
				token.setStart(entry.getValue().getStart());
				token.setEnd(entry.getValue().getEnd());
				token.setGene_Sign(entry.getValue().getGene_Sign());
				token.setGene_Mark(entry.getValue().getGene_Mark());
				token.addToIndexes();
				mapcompare.put("|"+Integer.toString(entry.getValue().getStart()), 0.1d);
				mapcompare.put(Integer.toString(entry.getValue().getEnd())+"|", 0.1d);
			
				mapcompare.put(entry.getValue().getGene_Mark(), 0.1d);
			}
		}
		
		Iterator abner = mapAbner.entrySet().iterator();
		
		while (abner.hasNext()) {
			Map.Entry<String, Annotation> entry = (Entry<String, Annotation>) abner
					.next();

			if (!mapcompare.containsKey("|" + entry.getValue().getStart())
					&& !mapcompare.containsKey(entry.getValue().getEnd() + "|")
					&& !mapcompare.containsKey(entry.getValue().getGene_Mark())
					&& Match(entry.getKey(), mapLingpipe)) {
				Consumer token = new Consumer(aJCas);
				token.setStart(entry.getValue().getStart());
				token.setEnd(entry.getValue().getEnd());
				token.setGene_Sign(entry.getValue().getGene_Sign());
				token.setGene_Mark(entry.getValue().getGene_Mark());
				token.addToIndexes();
				//System.out.println("good");
			}
		}
	

	}
	/**
	   * Description: This function is used for matching the start point of the current gene tag. Thus, by using 
	   * hashmap traversing method to match substring, we will remove some repeating data.
	   * 
	   * @author machongshen
	   */
	public boolean Match(String key, Map<String, Annotation> map) {

		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Annotation> entry = (Map.Entry<String, Annotation>) it
					.next();
			if (entry.getKey().indexOf(key) != -1) {
				return true;
			}
		}
		return false;
	}

}
