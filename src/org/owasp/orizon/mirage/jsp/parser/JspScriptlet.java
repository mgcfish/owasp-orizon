/* Generated by: FreeCC 0.9.3. Do not edit. JspScriptlet.java */
package org.owasp.orizon.mirage.jsp.parser;

public class JspScriptlet extends BaseNode {
    private String image;
    public String toString() {
        return super.toString()+" - "+getImage();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image=image;
    }

    public JspScriptlet(int id) {
        super(id);
    }

    public JspScriptlet() {
        super(JspConstants.JSPSCRIPTLET);
    }

}
