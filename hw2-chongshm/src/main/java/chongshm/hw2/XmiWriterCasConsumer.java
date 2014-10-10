package chongshm.hw2;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.XMLSerializer;
import org.xml.sax.SAXException;

import chongshm.hw2.*;
import edu.cmu.deiis.types.Consumer;

/**
 * Description: A simple CAS consumer that writes the CAS to a output file.
 * <p>
 * This CAS Consumer takes one parameter:
 * <ul>
 * <li><code>OutputDirectory</code> - path to directory into which output files
 * will be written</li>
 * </ul>
 */
public class XmiWriterCasConsumer extends CasConsumer_ImplBase {
	/**
	 * Description: Name of configuration parameter that must be set to the path
	 * of a directory into which the output files will be written.
	 * 
	 * @param ARAM_INTPUTDIR
	 *            represents the golden answer path. PARAM_OUTPUTDIR represents
	 *            the output result path.
	 * @author machongshen
	 */
	public static Evaluator a = new Evaluator();
	public static int answercount = 0;
	public int anothercount = 0;
	public static final String PARAM_INTPUTDIR = "./src/main/resources/inputData/sample.out";
	public static final String PARAM_OUTPUTDIR = "OutputDirectory";

	/**
	 * Description: For the initialize() function, we need to initialize the
	 * file, because we what to save the processed data. When we run again, we
	 * will make the file clean.
	 * 
	 */
	public void initialize() throws ResourceInitializationException {
		String sentence = ((String) getConfigParameterValue(PARAM_OUTPUTDIR))
				.trim();
		File f = new File(sentence);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			a.setAnswerText(PARAM_INTPUTDIR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Description:
	 * 
	 * @author machongshen Processes the CAS which was populated by the
	 *         TextAnalysisEngines. <br>
	 *         In this case, the CAS wrote the Gene Name Entity into the output
	 *         file. The output file is listing the Gene tag and name which is
	 *         generated from the TextAnalysisEngines.
	 * 
	 * @param aCAS
	 *            a CAS which has been populated by the TAEs
	 * 
	 * 
	 * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
	 */
	public void processCas(CAS aCAS) throws ResourceProcessException {

		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}

		String docText = jcas.getDocumentText();
		String[] k = docText.split(" ", 2);

		try {
			String sentence = ((String) getConfigParameterValue(PARAM_OUTPUTDIR))
					.trim();
			FileWriter fw = new FileWriter(sentence, true);
			BufferedWriter output = new BufferedWriter(fw);
			FSIterator it = jcas.getAnnotationIndex(
					edu.cmu.deiis.types.Consumer.type).iterator();
			char[] abc = k[1].toCharArray();
			String Gene_Sign = "";
			String Gene_Mark = "";

			String test = "";
			int start = 0;
			int end = 0;

			anothercount++;

			while (it.hasNext()) {
				int count = 0;
				int count1 = 0;
				//
				//
				Consumer annotation = (Consumer) it.next();
				Gene_Sign = annotation.getGene_Sign();
				Gene_Mark = annotation.getGene_Mark();
				/**
				 * This two "for" loop intend to get the accurate "start" and
				 * "end" position. With 2 count, I could use it to calculate the
				 * numbers of all spaces.
				 * 
				 * @author machongshen
				 * 
				 */
				for (int i = 0; i < annotation.getStart(); i++) {
					if (abc[i] == ' ') {
						count++;
					}

				}
				for (int i = annotation.getStart(); i < annotation.getEnd(); i++) {
					if (abc[i] == ' ') {
						count1++;
					}

				}
				start = annotation.getStart() - count;
				end = annotation.getEnd() - count - count1 - 1;
				test = Gene_Mark;

				output.append(Gene_Sign + "|" + start + " " + end + "|"
						+ Gene_Mark);
				answercount++;
				a.setAnswernum(answercount);
				a.judgeAnswer(test);
				output.newLine();
				output.flush();
			}

			fw.close();
			output.close();

			// if (anothercount==((jcas.size()/200)))
			// {
			//a.printReport();
			// }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// retrieve the filename of the input file from the CAS

	}

}