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
    private Object[] table;
    
    public DictHashTable(int capacity)
    {
    	this.table = new Object[capacity];
    	this.numElem = 0;
    }
    
    private int hash(Object key)
    {
    	int result = 3;
    	char array[] = key.toString().toLowercase().toCharArray();
    	for(int x = 0; x < charArray.length; x++)
    	{
    		result += ((int)(charArray[x])) * 3;
    	}
    	return (result%this.tableCapacity)
    }
}//END DICTHASHTABLE
