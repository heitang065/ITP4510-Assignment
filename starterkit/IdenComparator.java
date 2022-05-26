/*
 * Interface : S t r i n g C o m p a r a t o r
 * 
 * @Name : Tang Chun Hei
 * @StdID: 200022972
 * @Class: IT114105/1D
 * @2021-02-19
 */
public class IdenComparator implements Comparator {
	 
	public boolean isEqualTo (Object item1, Object item2) {
        return (((Identifier) item1).iden.compareTo(((Identifier) item2).iden) == 0);
    }
	
    public boolean isLessThan (Object item1, Object item2) {
        return (((Identifier) item1).iden.compareTo(((Identifier) item2).iden) < 0);
    }

    //public boolean isLessThanOrEqualTo (Object item1, Object item2) {
        //return (((Identifier) item1).iden.compareTo(((Identifier) item2).iden) <= 0);
    //}
    
    public boolean isGreaterThan (Object item1, Object item2) {
        return (((Identifier) item1).iden.compareTo(((Identifier) item2).iden) > 0);
    }
    
    //public boolean isGreaterThanOrEqualTo (Object item1, Object item2) {
        //return (((Identifier) item1).iden.compareTo(((Identifier) item2).iden) >= 0);
    //}
 }