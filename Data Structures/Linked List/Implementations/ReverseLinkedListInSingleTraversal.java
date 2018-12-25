class gfg
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverse(Node head)
   {
        // add code here
        Node temp = null;
        Node dummy = null;
        while(head!=null)
        {
            temp = head;
            head = head.next;
            temp.next = dummy;
            dummy = temp;
            
        }
        return dummy;
   }
}
