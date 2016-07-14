package com.mangocity.de.mbr.util.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;

/**
 * mongoDB工具类
 * @author longshu.chen
 *
 */
public class MongoDBUtil {
public static final String host="10.10.152.107";
	
	public static final int port=27017;
	
	public static final String databaseName="test";
	
	public static MongoClient mongoClient=null;
	
	public static MongoDatabase mdb=null;
	
	static{
		if (mongoClient == null){
			mongoClient=new MongoClient(host, port);
		}
		mdb=mongoClient.getDatabase(databaseName);
	}
	
	public  static MongoDBUtil getInstance(){
		return new MongoDBUtil();
	}
	
	/**
	 * 添加数据
	 * @param collectionName
	 * @param param
	 */
	public String insertOne(String collectionName,Map<String,Object> param){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		Document document=new Document(param);
		collection.insertOne(document);
		return document.get("_id").toString();
	}
	
//	public void insertMany(String collectionName,List<Map<String,Object>>  paramList){
//		MongoCollection<Document> collection=mdb.getCollection(collectionName);
//		collection.insertMany((List<? extends Document>) new Document(),new InsertManyOptions());
//	}
	
	/**
	 * 通过id删除一条数据
	 * @param collectionName
	 * @param param
	 * @return
	 */
	public Long deleteById(String collectionName,String id){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		DeleteResult result=collection.deleteOne(new Document("_id",new ObjectId(id)));
		return result.getDeletedCount();
	}
	
	/**
	 * 删除满足条件的多个数据
	 * @param collectionName
	 * @param param
	 * @return
	 */
	public Long deleteMany(String collectionName,Map<String,Object> param){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		DeleteResult result=collection.deleteMany(new Document(param));
		return result.getDeletedCount();
	}
	
	/**
	 * 更新满足条件的第一个数据
	 * @param collectionName
	 * @param param
	 * @param value
	 * @return
	 */
	public Long updateOne(String collectionName,Map<String,Object> param,Map<String,Object> value){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		Document document=new Document();
		if(value!=null){
			for (Entry<String, Object> entry : value.entrySet()) {    
				document.append("$set", new Document(entry.getKey(),entry.getValue()));
			}  
		}else{
			return 0L;
		}
		UpdateResult result=collection.updateOne(new Document(param), document);
		return result.getModifiedCount();
	}
	
	/**
	 * 更新满足条件的所有数据
	 * @param collectionName
	 * @param param
	 * @param value
	 * @return
	 */
	public Long updateMany(String collectionName,Map<String,Object> param,Map<String,Object> value){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		Document document=new Document();
		if(value!=null){
			for (Entry<String, Object> entry : value.entrySet()) {    
				document.append("$set", new Document(entry.getKey(),entry.getValue()));
			}  
		}else{
			return 0L;
		}
		UpdateResult result=collection.updateMany(new Document(param), document);
		return result.getModifiedCount();
	}
	/**
	 * 通过Id修改信息
	 * @param collectionName
	 * @param id
	 * @param param
	 * @return
	 */
	public Long updateById(String collectionName,String id,Map<String,Object> param){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		Document document=new Document();
		if(param!=null){
			for (Entry<String, Object> entry : param.entrySet()) {    
				document.append(entry.getKey(),entry.getValue());
			}  
		}else{
			return 0L;
		}
		UpdateResult result=collection.updateMany(new Document("_id",new ObjectId(id)), new Document("$set",document));
		return result.getModifiedCount();
	}
	
	/**
	 * 通过Id查询数据
	 * @param collectionName
	 * @param id
	 * @return
	 */
	public String selectById(String collectionName,String id){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		FindIterable<Document> result=collection.find(new Document("_id", new ObjectId(id)));
		String resultStr=JSON.serialize(result);
		return change(resultStr);
	}
	
	
	/**
	 * 通过id集合查询数据
	 * @param collectionName
	 * @param ids
	 * @return
	 */
	public String selectInIds(String collectionName,List<String> ids){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		List<ObjectId> oIds=new ArrayList<ObjectId>();
		for (String id : ids) {
			oIds.add(new ObjectId(id));
		}
		FindIterable<Document> result=collection.find(Filters.in("_id", oIds));
		String resultStr=JSON.serialize(result);
		return change(resultStr);
	}
	
	/**
	 * 通过属性查询数据
	 * @param collectionName
	 * @param param
	 * @return
	 */
	public String select(String collectionName,Map<String,Object> param){
		MongoCollection<Document> collection=mdb.getCollection(collectionName);
		FindIterable<Document> result=collection.find(new Document(param));
		String resultStr=JSON.serialize(result);
		return change(resultStr);
	}
	
	/**
	 * 复杂条件查询
	 * @param criteria
	 * @return
	 */
	public String select(Criteria criteria){
		FindIterable<Document> result=null;
		MongoCollection<Document> collection=mdb.getCollection(criteria.getCollectionName());
		if(criteria.getOperation().equals(Operation.eq)){
			result=collection.find(Filters.eq(criteria.getRestrictions().get(0).getName(), criteria.getRestrictions().get(0).getValue()));
			orderAndPage(result,criteria);
		}else if(criteria.getOperation().equals(Operation.gt)){
			result=collection.find(Filters.gt(criteria.getRestrictions().get(0).getName(), criteria.getRestrictions().get(0).getValue()));
			orderAndPage(result,criteria);
		}else if(criteria.getOperation().equals(Operation.lt)){
			result=collection.find(Filters.lt(criteria.getRestrictions().get(0).getName(), criteria.getRestrictions().get(0).getValue()));
			orderAndPage(result,criteria);
		}else if(criteria.getOperation().equals(Operation.like)){
			result=collection.find(Filters.regex(criteria.getRestrictions().get(0).getName(), (String) criteria.getRestrictions().get(0).getValue()));
			orderAndPage(result,criteria);
		}else if(criteria.getOperation().equals(Operation.and)){
			List<Restrictions> opreations=criteria.getRestrictions();
			result=collection.find(Filters.and(getBson(opreations)));
			orderAndPage(result,criteria);
		}else if(criteria.getOperation().equals(Operation.or)){
			List<Restrictions> opreations=criteria.getRestrictions();
			result=collection.find(Filters.or(getBson(opreations)));
			orderAndPage(result,criteria);
		}else if(criteria.getOperation().equals(Operation.in)){
			result=collection.find(Filters.in(criteria.getRestrictions().get(0).getName(),criteria.getRestrictions().get(0).getValueList()));
			orderAndPage(result,criteria);
		}else{
			result=collection.find();
			orderAndPage(result,criteria);
		}
		String resultStr=JSON.serialize(result);
		return change(resultStr);
	}
	
	/**
	 * 添加分页和排序条件
	 * @param result
	 * @param criteria
	 * @return
	 */
	private FindIterable<Document> orderAndPage(FindIterable<Document> result,Criteria criteria){
		List<Order> orders=criteria.getOrders();
		if(orders!=null && orders.size()>0){
			List<String> ascList=getOrder("asc",orders);
			List<String> descList=getOrder("desc",orders);
			if(ascList!=null && ascList.size()>0){
				result.sort(Sorts.ascending(ascList));
			}
			if(descList!=null && descList.size()>0){
				result.sort(Sorts.descending(descList));
			}
		}
		if(criteria.getMax() > criteria.getMin()){
			result.skip(criteria.getMin()).limit(criteria.getMax()-criteria.getMin());
		}
		return result;
	}
	
	/**
	 * 组装查询条件
	 * @param opreations
	 * @return
	 */
	private List<Bson> getBson(List<Restrictions> opreations){
		List<Bson> bsons=new ArrayList<Bson>();
		for (Restrictions opreation : opreations) {
			if(opreation.getOperation().equals(Operation.eq)){
				bsons.add(Filters.eq(opreation.getName(), opreation.getValue()));
			}else if(opreation.getOperation().equals(Operation.gt)){
				bsons.add(Filters.gt(opreation.getName(), opreation.getValue()));
			}else if(opreation.getOperation().equals(Operation.lt)){
				bsons.add(Filters.lt(opreation.getName(), opreation.getValue()));
			}else if(opreation.getOperation().equals(Operation.like)){
				bsons.add(Filters.regex(opreation.getName(), (String) opreation.getValue()));
			}
		}
		return bsons;
	} 
	
	/**
	 * 分类升序和降序
	 * @param type
	 * @param orders
	 * @return
	 */
	private List<String> getOrder(String type,List<Order> orders){
		List<String> names=new ArrayList<String>();
		for (Order order : orders) {
			if(order.getName().equals(type))
			names.add(order.getType());
		}
		return names;
	}
	
	/**
	 * 将_id字段转换成id字段
	 * @param data
	 * @return
	 */
	private String change(String data){
		JSONArray jsonArray=(JSONArray) JSONObject.parse(data);
		JSONArray newJsonArray=new JSONArray();
		JSONObject json=null;
		String idStr=null;
		for (int i = 0; i < jsonArray.size(); i++) {
			json=(JSONObject) jsonArray.get(i);
			idStr=(String) ((JSONObject)json.get("_id")).get("$oid");
			json.remove("_id");
			json.put("id", idStr);
			newJsonArray.add(json);
		}
		return newJsonArray.toJSONString();
	}
}
