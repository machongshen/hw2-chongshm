
/* First created by JCasGen Tue Oct 07 15:29:24 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Oct 07 15:43:11 EDT 2014
 * @generated */
public class Consumer_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Consumer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Consumer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Consumer(addr, Consumer_Type.this);
  			   Consumer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Consumer(addr, Consumer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Consumer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Consumer");
 
  /** @generated */
  final Feature casFeat_Gene_Sign;
  /** @generated */
  final int     casFeatCode_Gene_Sign;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGene_Sign(int addr) {
        if (featOkTst && casFeat_Gene_Sign == null)
      jcas.throwFeatMissing("Gene_Sign", "edu.cmu.deiis.types.Consumer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Gene_Sign);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGene_Sign(int addr, String v) {
        if (featOkTst && casFeat_Gene_Sign == null)
      jcas.throwFeatMissing("Gene_Sign", "edu.cmu.deiis.types.Consumer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Gene_Sign, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Gene_Mark;
  /** @generated */
  final int     casFeatCode_Gene_Mark;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGene_Mark(int addr) {
        if (featOkTst && casFeat_Gene_Mark == null)
      jcas.throwFeatMissing("Gene_Mark", "edu.cmu.deiis.types.Consumer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Gene_Mark);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGene_Mark(int addr, String v) {
        if (featOkTst && casFeat_Gene_Mark == null)
      jcas.throwFeatMissing("Gene_Mark", "edu.cmu.deiis.types.Consumer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Gene_Mark, v);}
    
  
 
  /** @generated */
  final Feature casFeat_start;
  /** @generated */
  final int     casFeatCode_start;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getStart(int addr) {
        if (featOkTst && casFeat_start == null)
      jcas.throwFeatMissing("start", "edu.cmu.deiis.types.Consumer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_start);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setStart(int addr, int v) {
        if (featOkTst && casFeat_start == null)
      jcas.throwFeatMissing("start", "edu.cmu.deiis.types.Consumer");
    ll_cas.ll_setIntValue(addr, casFeatCode_start, v);}
    
  
 
  /** @generated */
  final Feature casFeat_end;
  /** @generated */
  final int     casFeatCode_end;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getEnd(int addr) {
        if (featOkTst && casFeat_end == null)
      jcas.throwFeatMissing("end", "edu.cmu.deiis.types.Consumer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_end);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setEnd(int addr, int v) {
        if (featOkTst && casFeat_end == null)
      jcas.throwFeatMissing("end", "edu.cmu.deiis.types.Consumer");
    ll_cas.ll_setIntValue(addr, casFeatCode_end, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Consumer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Gene_Sign = jcas.getRequiredFeatureDE(casType, "Gene_Sign", "uima.cas.String", featOkTst);
    casFeatCode_Gene_Sign  = (null == casFeat_Gene_Sign) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Gene_Sign).getCode();

 
    casFeat_Gene_Mark = jcas.getRequiredFeatureDE(casType, "Gene_Mark", "uima.cas.String", featOkTst);
    casFeatCode_Gene_Mark  = (null == casFeat_Gene_Mark) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Gene_Mark).getCode();

 
    casFeat_start = jcas.getRequiredFeatureDE(casType, "start", "uima.cas.Integer", featOkTst);
    casFeatCode_start  = (null == casFeat_start) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_start).getCode();

 
    casFeat_end = jcas.getRequiredFeatureDE(casType, "end", "uima.cas.Integer", featOkTst);
    casFeatCode_end  = (null == casFeat_end) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_end).getCode();

  }
}



    