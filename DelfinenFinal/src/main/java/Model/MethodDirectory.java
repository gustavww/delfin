
package Model;

import Database.MedlemMapper;


public class MethodDirectory {
     
    MedlemMapper pm = new MedlemMapper();
     
     public void Insert(Medlem medlem){
         pm.InsertMedlem(medlem, "medlem");
     }

     public void InsertKonkurrence(int id){
         pm.InsertKonkurrence(id, "konkurrencemedlem");
     }
     
     public void Update(String disciplin, int id, int nummer){
         pm.DisciplinUpdate(disciplin, id, nummer, "konkurrencemedlem");
     }
     
     public void Remove(int id){
         pm.RemoveMedlem(id, "medlem");
         pm.RemoveMedlem(id, "konkurrencemedlem");
     }
     
     public void RemoveKonkurrence(int id){
         pm.RemoveMedlem(id, "konkurrencemedlem");
     }
     
     public void showTopFive(String discipline){
         pm.SearchDiscipline(discipline, "konkurrencemedlem");
     }
        
   }

