/*
 * Interface : C o m p a r a t o r
 * 
 * @Name : Tang Chun Hei
 * @StdID: 200022972
 * @Class: IT114105/1D
 * @2021-02-19
 */
public interface Comparator {
    public abstract boolean isEqualTo (Object item1, Object item2);
    public abstract boolean isLessThan (Object item1, Object item2);
    // public abstract boolean isLessThanOrEqualTo(Object item1, Object item2); // unnecessary
    public abstract boolean isGreaterThan (Object item1, Object item2);
    // public abstract boolean isGreaterThanOrEqualTo (Object item1, Object item2); // unnecessary
}

