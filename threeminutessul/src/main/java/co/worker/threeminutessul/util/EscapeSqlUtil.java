package co.worker.threeminutessul.util;

public class EscapeSqlUtil {
   
   private static EscapeSqlUtil instance;
   public static EscapeSqlUtil getInstance(){
      if (instance == null)
           instance = new EscapeSqlUtil();
        
        return instance;
   }
   
   /**
    * like 절을 class단에서 생성할때 like 절에 들어가는 내용을 escape 처리 한다.
    * @param value
    * @return
    * @throws Exception
    */
   public String escapeWildCard(String value) throws Exception{
      if(value == null || value.equals("")){
         return value;
      }
      value = "lower('%"+value.replaceAll("'", "''").replaceAll("\\\\", "\\\\\\\\").replaceAll("%", "\\\\%").replaceAll("_", "\\\\_")+"%') ESCAPE '\\' ";
      return value;
   }
   
   /**
    * like 절을 class단에서 생성할때 like 절에 들어가는 내용을 escape 처리 한다.
    * @param value
    * @return
    * @throws Exception
    */
   public String escapeSearchText(String value) throws Exception{
      if(value == null || value.equals("")){
         return value;
      }
//      value = value.replaceAll("'", "''").replaceAll("\\\\", "\\\\\\\\").replaceAll("%", "\\\\%").replaceAll("_", "\\\\_");
      value = value.replaceAll("\\\\", "\\\\\\\\").replaceAll("%", "\\\\%").replaceAll("_", "\\\\_");
      return value;
   }
   
   public String unEscapeSearchText(String value) throws Exception{
      if(value == null || value.equals("")){
         return value;
      }
//      value = value.replaceAll("'", "''").replaceAll("\\\\", "\\\\\\\\").replaceAll("%", "\\\\%").replaceAll("_", "\\\\_");
      value = value.replaceAll("\\\\\\\\", "\\\\").replaceAll("\\\\%", "%").replaceAll("\\\\_", "_");
      return value;
   }
}