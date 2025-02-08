package ppkr.rays;

public class DBConstants {
	
	public static final String AGRI_SCHEMA_NAME = "agri_poc_schema";
	
	/*** FARMS ***/
	public static final String FARMS_TABLE_NAME = "FARMS";
	public static final String FARMS_ID_COL_NAME = "ID";
	public static final String FARMS_NAME_COL_NAME = "NAME";
	public static final String FARMS_OWNER_NAME_COL_NAME = "OWNER_NAME";
	public static final String FARMS_LOCATION_COL_NAME = "LOCATION";
	public static final String FARMS_AREA_COL_NAME = "AREA";
	public static final String FARMS_SY_NO_COL_NAME = "SY_NO";

	/*** CROPS ***/
	public static final String CROPS_TABLE_NAME = "CROPS";
	public static final String CROPS_ID_COL_NAME = "ID";
	public static final String CROPS_FARM_ID_COL_NAME = "FARM_ID";
	public static final String CROPS_NAME_COL_NAME = "NAME";
	public static final String CROPS_DENSITY_COL_NAME = "DENSITY";
	public static final String CROPS_TYPE_COL_NAME = "TYPE";
	public static final String CROPS_PLANTED_DATE_COL_NAME = "PLANTED_DATE";
	public static final String CROPS_NO_OF_YIELDS_COL_NAME = "NO_OF_YIELDS";
	
	public static final String getSchemaQualifiedName(String schema_name, String table_name) {
		return schema_name+"."+table_name;
	}
	
}
