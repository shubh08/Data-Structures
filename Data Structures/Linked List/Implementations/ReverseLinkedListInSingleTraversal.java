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
            temp = head; // take copy of the current node
            head = head.next; // Move the header to next node;
            temp.next = dummy; // assign the next of the current node to dummy
            dummy = temp; // reassign the dummy to store the current node for next traversal move
            
        }
        return dummy;
   }
}
