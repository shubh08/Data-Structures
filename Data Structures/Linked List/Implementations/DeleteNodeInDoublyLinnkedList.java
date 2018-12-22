class GfG
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	 
	 if(head == null) return null;
	 
	 if(x==1) return head.next;
	 int position =1;
	 Node headRef = head;
	 while(head != null)
	    if(position == x)
	    {
	        head.prev.next = head.next;
	        if(head.next!= null)
	        head.next.prev = head.prev;
	    
	        break;
	    }
	 else{
	     head = head.next;
	     position++;
	 }
	 return headRef;
    
	 
    }
}
