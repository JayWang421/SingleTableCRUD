package wzj.uti.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public interface IBaseDAO<K,V> {
	public boolean doCreate(V vo)throws SQLException ;
	public boolean doUpdate(V vo)throws SQLException ;
	public boolean doRemove(K rid)throws SQLException ;
	public V findById(K rid)throws SQLException ;
	public List<V> findAll()throws SQLException;
	public List<V> findAllSplit(K currentPage,K lineSize)throws SQLException;
	public List<V> findAllSplit(K currentPage,K lineSize, String column,String keyword)throws SQLException;
	public K getCount() throws SQLException ;
	public K getCount(String column,String keyword) throws SQLException ;
	public boolean doRemoveBatch(Set<K> ids)throws SQLException ;
}
