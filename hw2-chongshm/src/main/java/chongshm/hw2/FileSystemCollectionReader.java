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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.DocumentAnnotation;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

/**
 * Description: A simple collection reader that reads documents from a directory
 * in the file system line by line. By using the BufferedReader function. I
 * realized this function. It can be configured with the following parameters:
 * 
 * 
 * @author machongshen
 * 
 * 
 */
public class FileSystemCollectionReader extends CollectionReader_ImplBase {
	/**
	 * Description: Name of configuration parameter that must be set to the path
	 * of a directory containing input files.
	 * 
	 * @param PARAM_INPUTDIR
	 *            The path of input material
	 */
	public static final String PARAM_INPUTDIR = "InputDirectory";

	private ArrayList<String> sentences;

	private int mCurrentIndex;

	/**
	 * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
	 *      Set the path of the input file.
	 */
	public void initialize() throws ResourceInitializationException {

		String sentence = ((String) getConfigParameterValue(PARAM_INPUTDIR))
				.trim();
		mCurrentIndex = 0;
		try {
			sentences = linereadfile(sentence);
		} catch (Exception e) {
		}

	}

	/**
	 * This method read the each lines of the input file in the directory, save
	 * the each sentences to a Arraylist.
	 * 
	 * @param sentences
	 *            Store the s
	 * 
	 */
	public ArrayList<String> linereadfile(String sentence) throws Exception {

		String line = null;
		sentences = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader(sentence));

		while ((line = in.readLine()) != null) {

			sentences.add(line);
		}
		in.close();
		return sentences;
	}

	/**
	 * @see org.apache.uima.collection.CollectionReader#hasNext()
	 */
	public boolean hasNext() {
		return mCurrentIndex < sentences.size();
	}

	/**
	 * @see org.apache.uima.collection.CollectionReader#getNext(org.apache.uima.cas.CAS)
	 */
	public void getNext(CAS aCAS) throws IOException, CollectionException {
		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new CollectionException(e);
		}
		/**
		 * test
		 */

		String line = (String) sentences.get(mCurrentIndex++);
		jcas.setDocumentText(line);
		// System.out.println(line);
	}

	/**
	 * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#close()
	 */
	public void close() throws IOException {
	}

	/**
	 * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#getProgress()
	 */
	public Progress[] getProgress() {
		return new Progress[] { new ProgressImpl(mCurrentIndex,
				sentences.size(), Progress.ENTITIES) };
	}

	/**
	 * Gets the total number of documents that will be returned by this
	 * collection reader. This is not part of the general collection reader
	 * interface.
	 * 
	 * @return the number of documents in the collection
	 */
	public int getNumberOfDocuments() {
		return sentences.size();
	}

}
