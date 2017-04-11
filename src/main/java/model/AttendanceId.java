package main.java.model;
// Generated Apr 11, 2017 10:02:26 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * AttendanceId generated by hbm2java
 */
public class AttendanceId  implements java.io.Serializable {


     private String studentId;
     private String subjectId;
     private Date checkInDate;

    public AttendanceId() {
    }

    public AttendanceId(String studentId, String subjectId, Date checkInDate) {
       this.studentId = studentId;
       this.subjectId = subjectId;
       this.checkInDate = checkInDate;
    }
   
    public String getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getSubjectId() {
        return this.subjectId;
    }
    
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public Date getCheckInDate() {
        return this.checkInDate;
    }
    
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AttendanceId) ) return false;
		 AttendanceId castOther = ( AttendanceId ) other; 
         
		 return ( (this.getStudentId()==castOther.getStudentId()) || ( this.getStudentId()!=null && castOther.getStudentId()!=null && this.getStudentId().equals(castOther.getStudentId()) ) )
 && ( (this.getSubjectId()==castOther.getSubjectId()) || ( this.getSubjectId()!=null && castOther.getSubjectId()!=null && this.getSubjectId().equals(castOther.getSubjectId()) ) )
 && ( (this.getCheckInDate()==castOther.getCheckInDate()) || ( this.getCheckInDate()!=null && castOther.getCheckInDate()!=null && this.getCheckInDate().equals(castOther.getCheckInDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getStudentId() == null ? 0 : this.getStudentId().hashCode() );
         result = 37 * result + ( getSubjectId() == null ? 0 : this.getSubjectId().hashCode() );
         result = 37 * result + ( getCheckInDate() == null ? 0 : this.getCheckInDate().hashCode() );
         return result;
   }   


}

