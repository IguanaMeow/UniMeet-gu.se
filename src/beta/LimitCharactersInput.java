package gu.se.project.beta;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 * 
 * LimitCharactersInput.java
 * Purpose: used to limit JTextFields length.
 *
 * @author Omar 
 * @version 1.0 
 */
public class LimitCharactersInput extends PlainDocument {

	
	private int limit;
	  LimitCharactersInput(int limit) {
	    super();
	    this.limit = limit;
	  }

	  LimitCharactersInput(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int i, String s, AttributeSet attr) throws BadLocationException {
	    if (s == null)
	      return;

	    if ((getLength() + s.length()) <= limit) {
	      super.insertString(i, s, attr);
	    }
	  }


}
