package Exercicio_2;

/**
 * Class to use for define a DoubleNode for the DoubleLinkedLists
 * @param <T>
 */
public class DoubleNode <T>{


    private T element;

    //Variables used for save the references next and previous Element
    private DoubleNode<T> next;
    private DoubleNode<T> prv;


    /**
     * Constructor used for null element
     */
    public DoubleNode(){
        this.element = null;
    }

    /**
     *Constructor used for the double node use the element in the param
     *
     * @param Element used for build the Double Node
     */
    public DoubleNode(T Element){
        this.element = Element;
        next = null;
        prv = null;
    }

    // geters e seters

    /**
     * Get the element
     * @return element
     */
    public T getElement(){
        return this.element;
    }

    /**
     * Set the new element in the element
     * @param element to set in element
     */
    public void setElement(T element){
        this.element=element;
    }

    /**
     * Get a next DoubleNode
     *
     * @return next node
     */
    public DoubleNode <T> getNext(){
        return this.next;
    }

    /**
     * Set the param e1 in the next DoubleNode
     *
     * @param e1 used for set
     */
    public void setNext(DoubleNode <T> e1){
        this.next = e1;
    }

    /**
     * Get the Node previous
     *
     * @return the previous
     */
    public DoubleNode<T> getPrv(){
        return this.prv;
    }

    /**
     * Set the param e1 in teh previous
     * @param e1
     */
    public void setPrv(DoubleNode<T> e1){
        this.prv = e1;
    }

}