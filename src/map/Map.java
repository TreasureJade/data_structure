package map;

/**
 * @author hobo
 * @description
 */
public interface Map<K,V> {

    /**
     * 添加一个键值对
     * @param key
     * @param value
     */
    void add(K key,V value);

    /**
     * 根据键删除键值对
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 判断是否有键
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 根据键查询值
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 将Key对应的Value值修改
     * @param key
     * @param newValue
     */
    void set(K key,V newValue);

    /**
     * 查询映射的长度
     * @return
     */
    int getSize();

    /**
     * 判断映射是否为空
     * @return
     */
    boolean isEmpty();
}
