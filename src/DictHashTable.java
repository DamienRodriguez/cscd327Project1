public class DictHashTable
{
    private class Record
    {
    	private Object key;
    	private Object value;
    	
    	public Record(Object key, Object val)
    	{
    		this.key = key;
    		this.value = val;
    	}
    	
    	public boolean equals(Object obj)
    	{
    		if(obj instanceof(Record))
    		{
    			Record r = (Record)obj;
    			return this.key.equals(r.key);
    		}
    		return false;
    	}
    }//END RECORD
    
    private int tableCapacity = 100000;
    private int numElem;
    private obj[] table;
    
    public DictHashTable(int capacity)
    {
    	this.table = new Object[capacity];
    	this.numElem = 0;
    }
}//END DICTHASHTABLE
