package chongshm.hw2;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import abner.*;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.deiis.types.Annotation;
import edu.cmu.hw2chongshm.types;
/**
 * Description: By using the Abner API as NER to generate gene tag. In the meantime, we also compare the output
 * of Abner, and use the regular expression to exclude the inconceivable data. Then save the data to the CAS.
 * @see <url>http://pages.cs.wisc.edu/~bsettles/abner/</url>
 * @author machongshen
 * 
 */
public class Abner_Annotator extends JCasAnnotator_ImplBase {
	public static Tagger a = new Tagger();

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		String docText = aJCas.getDocumentText();
		String[] k = docText.split(" ", 2);
		String[][] m = a.getEntities(k[1]);
		int start = 0;
		int end = 0;
		for (int i = 0; i < m[0].length; i++) {
			Annotation types = new 	Annotation(aJCas);
			String extract = m[0][i];
			 String extract2 = m[1][i];
			double sb = 0.61d;
			/**
			 * Description: use the regular expression and irrelative information to exclude the inconceivable data.
			 * This method helps me improve the precision of the extracting gene tag.
			 * 
			 */		
			if (k[1].indexOf(extract) != -1&&extract2!="CELL_TYPE"&&extract2!="RNA"&&extract.length()>1) {
				start = k[1].indexOf(extract);
				if (Pattern.matches("[0-9a-zA-Z-\\s]+", extract) == false) {
					sb = 0.1d;
				} 
				if (sb!=0.1d){
				end = start + m[0][i].length();
				types.setGene_Sign(k[0]);
				types.setGene_Mark(extract);
				types.setStart(start);
				types.setEnd(end);
				types.setConfidence(sb);
				types.setCasProcessorId("abner");
				types.addToIndexes();
				
				}
			}
			
		}

	}

}
