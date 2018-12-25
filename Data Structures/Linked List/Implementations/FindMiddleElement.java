class GFG
{
    // Function to find middle element a linked list
    int getMiddle(Node head)
   {
       if(head==null) return -1;
         Node fastPtr = head;
         Node slowPtr = head;
         while(fastPtr.next!=null && fastPtr.next.next!=null)
         {
             slowPtr = slowPtr.next;
             fastPtr = fastPtr.next.next;
         }
         if(fastPtr.next!=null)
         {
             slowPtr = slowPtr.next;
         }
         return slowPtr.data;
   }
}
