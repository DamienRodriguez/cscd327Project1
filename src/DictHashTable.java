//created by Ryan with partner Damien
import java.util.*;

public class DictHashTable
{
    private class Record
    {
    	private Object key;
    	private Object value;
    	
    	public Record()
    	{
    		this.key = null;
    		this.value = null;
    	}
    	
    	public Record(Object key, Object val)
    	{
    		this.key = key;
    		this.value = val;
    	}
    	
    	public boolean equals(Object obj)
    	{
    		if(obj instanceof Record)
    		{
    			Record r = (Record)obj;
    			return this.key.equals(r.key);
    		}
    		return false;
    	}
    }//END RECORD
    
    private int tableSize = 100000;
    private int numElements;
    private Object[] table;
    
    public DictHashTable(int capacity)
    {
    	this.table = new Object[capacity];
    	this.numElements = 0;
    }
    
    public int getNumElements() {
		return this.numElements;
	}
    
    private int hash(Object key)
    {
    	int result = 3;
    	char array[] = key.toString().toLowerCase().toCharArray();
    	for(int x = 0; x < array.length; x++)
    	{
    		result += ((int)(charArray[x])) * 3;
    	}
    	return (result % this.table.length)
    }
    
    public void put(Object key, Object data) {
		if (data == null || key == null) {
			System.err.println("ERROR: Either the key or the data are null");
			return;
		}

		if (this.contains(key)) {
			remove(key);
		}
		
		int pos = this.hash(key);
		 
		if (this.table[pos] == null) {
			this.table[pos] = new LinkedList<Record>();
		}
		
		LinkedList<Record> theList = (LinkedList<Record>) this.table[pos];
		theList.add(new Record(key, data));
		this.numElements++;
	}
    
    public void put(Object [] keys, Object [] inputData) {
		for (int i = 0; i < inputData.length; i++) {
			this.put(keys[i], inputData[i]);
		}
	}
    
    public Object get(Object key) {
        int index = hash(key);
        
        Object data = null;
        
        if(this.table[index] != null)
        {
        	Record temp = new Record();
        	temp.key = key;
        	LinkedList<Record> list = (LinkedList<Record>)this.table[index];
        	
        	for(int x = 0; x < list.size() && data == null; x++)
        	{
        		if(temp.key.equals(((Record)list.get(x)).key))
        		{
        			data = ((Record)list.get(x)).value;
        		}
        	}
        }
        return data;
    }
    
    public boolean contains(Object key) {
		boolean result = false;
		int hash = this.hash(key);

		if (this.table[hash] != null) {
			Record node = new Record();
			node.key = key;
			if (((LinkedList<Record>)this.table[hash]).indexOf(node) > -1) {
				result = true;
			}
		}
		return result;
	}
}//END DICTHASHTABLE
