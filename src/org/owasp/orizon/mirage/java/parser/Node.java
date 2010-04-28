/* Generated by: FreeCC 0.9.3. Node.java */
package org.owasp.orizon.mirage.java.parser;

public interface Node {
    /** Life-cycle hook method called after the node has been made the current
	 *  node 
	 */
    void open();
    /** 
  	 * Life-cycle hook method called after all the child nodes have been
     * added. 
     */
    void close();
    void setParent(Node n);
    Node getParent();
    // The following 9 methods will typically just 
    // delegate straightforwardly to a List object that
    // holds the child nodes
    void addChild(Node n);
    void addChild(int i,Node n);
    Node getChild(int i);
    void setChild(int i,Node n);
    Node removeChild(int i);
    boolean removeChild(Node n);
    int indexOf(Node child);
    void clearChildren();
    //     int getNumChildren();
    int getChildCount();
    // The following 3 methods will typically delegate
    // straightforwardly to a Map<String, Object> object-s get/set/containsKey/keySet methods.
    Object getAttribute(String name);
    void setAttribute(String name,Object value);
    boolean hasAttribute(String name);
    java.util.Set<String>getAttributeNames();
    // The following ten methods are for location info.
    /**
      * @return A string that says where the input came from. Typically a file name, though
      *         it could be a URL or something else, of course.  
      */
    String getInputSource();
    void setInputSource(String inputSource);
    int getBeginLine();
    int getEndLine();
    int getBeginColumn();
    int getEndColumn();
    void setBeginLine(int beginLine);
    void setEndLine(int endLine);
    void setBeginColumn(int beginColumn);
    void setEndColumn(int endColumn);
    int getId();
}
