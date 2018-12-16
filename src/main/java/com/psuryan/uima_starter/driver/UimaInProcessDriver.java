package com.psuryan.uima_starter.driver;

import java.io.IOException;
import java.io.InputStream;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

public class UimaInProcessDriver {
  public static void main(String[] args) {
    try {
      new UimaInProcessDriver().go();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void go() throws Exception {
    String docText = "Conference Rooms at Watson:" + "\nLocation	Capacity 	Wall Phone Ext."
            + "\nClassroom Style" + "\n  HAW J2-B34 	Seats 12 	tieline 863-3130"
            + "\n  HAW J2-N07 	Seats 24 	tieline 863-3210"
            + "\n  YKT 20-001 	Seats 36 	tieline 862-4304"
            + "\n  YKT 20-051 	Seats 18 	tieline 862-4307";

    AnalysisEngine ae = createAnalysisEngine("/ae/RoomNumberAnnotator.xml");
    process(docText, ae);
  }

  private AnalysisEngine createAnalysisEngine(String descriptor)
          throws InvalidXMLException, IOException, ResourceInitializationException {
    InputStream is = this.getClass().getResourceAsStream(descriptor);
    XMLInputSource descriptorSource = new XMLInputSource(is, null);
    ResourceSpecifier specifier = UIMAFramework.getXMLParser()
            .parseResourceSpecifier(descriptorSource);
    return UIMAFramework.produceAnalysisEngine(specifier);
  }

  private void process(String text, AnalysisEngine ae)
          throws ResourceInitializationException, AnalysisEngineProcessException {
    JCas jcas = ae.newJCas();
    jcas.setDocumentText(text);
    ae.process(jcas);
    if (jcas != null) {
      AnnotationIndex<Annotation> annotations = jcas.getAnnotationIndex();
      FSIterator<Annotation> fsI = annotations.iterator();
      while (fsI.hasNext()) {
        Annotation an = fsI.next();
        System.out.println("<" + an.getType().getName() + ":" + an.getBegin() + ">"
                + an.getCoveredText() + "</" + an.getType().getName() + ":" + an.getEnd() + ">");
      }
    }
  }
}
