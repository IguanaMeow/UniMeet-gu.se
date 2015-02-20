

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JLetterField extends JTextField{
    private int limit;
	public JLetterField(int cols, int limit) {
       super("",cols);
       this.limit = limit;
    }

    protected Document createDefaultModel() {
        return new LetterDocument();
    }
    
    class LetterDocument extends PlainDocument {
        public void insertString(int offs,String str,AttributeSet a)
        throws BadLocationException
        {
            if(str==null) return;
            char [] before = str.toCharArray();
            String after = "";
            for(int i=0;i < before.length;i++)
            {
                if( ((before[i]>='a' && before[i]<='š') || (before[i]>='A' && before[i]<='…')) && (getLength() + str.length()) <= limit) 
                    after += before[i];
            }
            super.insertString(offs,after,a);
        }
    }    
}

