/* Generated by: FreeCC 0.9.3. Do not edit. BaseNode.java */
package org.owasp.orizon.mirage.java.parser;

import java.util.*;
public class BaseNode implements Node,JavaConstants {
    public int getId() {
        return id;
    }

    protected String getLiteralText() {
        StringBuilder buf=new StringBuilder();
        for(Token t : Nodes.getAllTokens(this,true,true)) {
            buf.append(t);
        }
        return buf.toString();
    }

    protected String getInnerText() {
        StringBuilder buf=new StringBuilder();
        List<Token>tokens=Nodes.getAllTokens(this,true,true);
        boolean outputOpeningBrace=false;
        for(int i=0; 
        i<tokens.size()-1; 
        i++) {
            Token t=tokens.get(i);
            if (outputOpeningBrace) {
                buf.append(t);
            }
            else if (t.getId()==LBRACE) {
                outputOpeningBrace=true;
            }
        }
        return buf.toString();
    }

    public ListIterator<Node>iterator() {
        return Nodes.iterator(this);
    }

    public void prepend(Node n) {
        ListIterator<Node>iterator=iterator();
        iterator.add(n);
    }

    public String getAsString() {
        return getLiteralText();
    }

    public boolean isEmpty() {
        return Nodes.getRealTokens(this).size()==0;
    }

    @SuppressWarnings("unchecked")
    static private Class listClass=java.util.ArrayList.class;
    @SuppressWarnings("unchecked")
    static public void setListClass(Class<?extends java.util.List>listClass) {
        BaseNode.listClass=listClass;
    }

    @SuppressWarnings("unchecked")
    private java.util.List<Node>newList() {
        try {
            return(java.util.List<Node>) listClass.newInstance();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final int id;
    protected Node parent;
    protected java.util.List<Node>children=newList();
    private int beginLine,beginColumn,endLine,endColumn;
    private String inputSource;
    private java.util.Map<String,Object>attributes;
    public BaseNode(int id) {
        this.id=id;
    }

    public void open() {
    }

    public void close() {
    }

    public void setParent(Node n) {
        parent=n;
    }

    public Node getParent() {
        return parent;
    }

    public void addChild(Node n) {
        children.add(n);
        n.setParent(this);
    }

    public void addChild(int i,Node n) {
        children.add(i,n);
        n.setParent(this);
    }

    public Node getChild(int i) {
        return children.get(i);
    }

    public void setChild(int i,Node n) {
        children.set(i,n);
        n.setParent(this);
    }

    public Node removeChild(int i) {
        return children.remove(i);
    }

    public boolean removeChild(Node n) {
        return children.remove(n);
    }

    public int indexOf(Node n) {
        return children.indexOf(n);
    }

    public void clearChildren() {
        children.clear();
    }

    public int getChildCount() {
        return children.size();
    }

    public Object getAttribute(String name) {
        return attributes==null?null:
        attributes.get(name);
    }

    public void setAttribute(String name,Object value) {
        if (attributes==null) {
            attributes=new java.util.HashMap<String,Object>();
        }
        attributes.put(name,value);
    }

    public boolean hasAttribute(String name) {
        return attributes==null?false:
        attributes.containsKey(name);
    }

    public java.util.Set<String>getAttributeNames() {
        if (attributes==null) return java.util.Collections.emptySet();
        return attributes.keySet();
    }

    public void setInputSource(String inputSource) {
        this.inputSource=inputSource;
    }

    public String getInputSource() {
        return inputSource;
    }

    public int getBeginLine() {
        if (beginLine<=0) {
            if (!children.isEmpty()) {
                beginLine=children.get(0).getBeginLine();
                beginColumn=children.get(0).getBeginColumn();
            }
        }
        return beginLine;
    }

    public int getEndLine() {
        if (endLine<=0) {
            if (!children.isEmpty()) {
                Node last=children.get(children.size()-1);
                endLine=last.getEndLine();
                endColumn=last.getEndColumn();
            }
        }
        return endLine;
    }

    public int getBeginColumn() {
        if (beginColumn<=0) {
            if (!children.isEmpty()) {
                beginLine=children.get(0).getBeginLine();
                beginColumn=children.get(0).getBeginColumn();
            }
        }
        return beginColumn;
    }

    public int getEndColumn() {
        if (endColumn<=0) {
            if (!children.isEmpty()) {
                Node last=children.get(children.size()-1);
                endLine=last.getEndLine();
                endColumn=last.getEndColumn();
            }
        }
        return endColumn;
    }

    public void setBeginLine(int beginLine) {
        this.beginLine=beginLine;
    }

    public void setEndLine(int endLine) {
        this.endLine=endLine;
    }

    public void setBeginColumn(int beginColumn) {
        this.beginColumn=beginColumn;
    }

    public void setEndColumn(int endColumn) {
        this.endColumn=endColumn;
    }

    public String toString() {
        StringBuilder buf=new StringBuilder();
        for(Token t : Nodes.getRealTokens(this)) {
            buf.append(t);
        }
        return buf.toString();
    }

}
