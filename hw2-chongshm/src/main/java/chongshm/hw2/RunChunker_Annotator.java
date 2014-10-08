package chongshm.hw2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.Level;
import org.apache.uima.util.ProcessTrace;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.Strings;

import edu.cmu.deiis.types.Annotation;
import edu.cmu.hw2chongshm.types;
/**@author machongshen
 * This annotator that discovers Gene Tag and Name in the file by using the Lingpipe API.
 * This code first creates the chunker, then analyzes each of the arguments using the 
 * chunker. It does this by pulling out the chunking, then pulling the set of chunks out 
 * of the chunking, then save each of these chunks. Then set them go to the 
 * 
 */

public class RunChunker_Annotator extends JCasAnnotator_ImplBase {
	static ConfidenceChunker chunker = null;
	public void initialize( UimaContext context ){
		File modelFile = new File(
				"./src/main/resources/inputData/output123");
		try {
			chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**@author machongshen
	 * This annotator that discovers Gene Tag and Name in the file by using the Lingpipe API.
	 * This code first creates the chunker, then analyzes each of the arguments using the 
	 * chunker. It does this by pulling out the chunking, then pulling the set of chunks out 
	 * of the chunking, then save each of these chunks. Then set them go to the 
	 * 
	 * @return void no need to return.
	 */
	@Override

	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		// TODO Auto-generated method stub
		// JCas jcas = null;

	/**  @see file "ne-en-bio-genetag.hmmchunker" from <url>http://alias-i.com/</url>
	 * Like Other models, ne-en-bio-genetag.hmmchunker is labeled by task (ne for named-entity recognition), 
	 * language (en for English), genre (bio for biology) and corpus (genetag for the GENETAG 
	 * corpus
	 * */
		
		String docText = aJCas.getDocumentText();
		String[] k = docText.split(" ", 2);
		char [] abc = k[1].toCharArray();
		//Chunking chunking = chunker.chunk(k[1]);
		//Set<Chunk> chunkSet = chunking.chunkSet();
		Iterator<Chunk> it = chunker.nBestChunks(abc,0,abc.length,40);
		while (it.hasNext()) {
			Annotation types = new Annotation(aJCas);
			Chunk chunk = it.next();
			double confidence = Math.pow(2.0,chunk.score());
			//System.out.println(confidence);
			if(confidence>0.5){
			int start = chunk.start();
			int end = chunk.end();
			String text = k[1].substring(start, end);
			types.setGene_Sign(k[0]);
			types.setGene_Mark(text);
			types.setStart(start);
			types.setEnd(end);
			types.setConfidence(confidence);
			types.setCasProcessorId("Lingpipe");
			types.addToIndexes();
			}
		}
	}
}