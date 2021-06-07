package Graph;



import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

public class Family {

    private HashMap<FamilyMember, Multimap<String, FamilyMember>> map;
    public ArrayList<FamilyMember> familyMembers;

    public Family() {
        map = new HashMap<>();
        familyMembers = new ArrayList<>();
    }


    public void addFamilyMember(FamilyMember person){
        if(map.containsKey(person)){
            System.out.println("Person already exist!");
        }else {
            Multimap<String,FamilyMember> temp = ArrayListMultimap.create();
            map.put(person,temp);
            familyMembers.add(person);
        }
    }

    public void addSibling(FamilyMember person1, FamilyMember person2) {
        if(map.containsKey(person1) && map.containsKey(person2)){
            if(!checkRelatives(person1).contains(person2)){
                map.get(person1).put("Sibling/s",person2);
                map.get(person2).put("Sibling/s",person1);
            }else {
                System.out.println("Person already a sibling of "+ person1);
            }
        }else{
            System.out.println("Person does not exist!");
        }
    }

    public void addMother(FamilyMember person1, FamilyMember person2){
        if(map.containsKey(person1) && map.containsKey(person2)){
            if(!checkRelatives(person1).contains(person2)){
                map.get(person1).put("Mother",person2);
                map.get(person2).put("Child",person2);
            }else {
                System.out.println("Person already a mother of "+ person1);
            }
        }else{
            System.out.println("Person does not exist!");
        }
    }

    public void addFather(FamilyMember person1,FamilyMember person2){
        if(map.containsKey(person1) && map.containsKey(person2)){
            if(!checkRelatives(person1).contains(person2)){
                map.get(person1).put("Father",person2);
                map.get(person2).put("Child",person2);
            }else {
                System.out.println("Person already a father of "+ person1);
            }
        }else{
            System.out.println("Person does not exist!");
        }

    }

    public void addChild(FamilyMember person1, FamilyMember person2){
        if(map.containsKey(person1) && map.containsKey(person2)){
            if(!checkRelatives(person1).contains(person2)){
                map.get(person1).put("Child",person2);
                if(familyMembers.get(indexOf(person2)).gender == true){
                    map.get(person2).put("Father",person1);
                }else {
                    map.get(person2).put("Mother",person1);
                }
            }else {
                System.out.println("Person already a child of "+ person1);
            }
        }else{
            System.out.println("Person does not exist!");
        }
    }

    public void addPartner(FamilyMember person1,FamilyMember person2){
        if(map.containsKey(person1) && map.containsKey(person2)){
            if(!checkRelatives(person1).contains(person2)){
                if(person1.gender != person2.gender){
                    if(person1.gender == true){
                        map.get(person1).put("Wife",person2);
                        map.get(person2).put("Husband",person1);
                    }else{
                        map.get(person1).put("Husband",person2);
                        map.get(person2).put("Wife",person1);
                    }
                }else{
                    System.out.println("Invalid gender");
                }
            }else {
                System.out.println("Person already a partner of "+ person1);
            }
        }else{
            System.out.println("Person does not exist!");
        }
    }


    private int indexOf(FamilyMember person){
        int res = 0;
        for(int i=0;i > familyMembers.size();i++){
            if(familyMembers.get(i).equals(person)){
                res = i;
            }
        }
        return res;
    }


    public String printTree(){
        StringBuilder builder = new StringBuilder();
        for(FamilyMember person: map.keySet()){
            builder.append(person + "\n");
            for(String value: map.get(person).keySet()){
                builder.append("        " + value + ":\n");
                for(FamilyMember v: map.get(person).get(value)){
                    builder.append("         * " + v + "\n");
                }
            }
            builder.append("\n");
        }


        return builder.toString();
    }

    public String printFamily(FamilyMember person){
        StringBuilder builder = new StringBuilder();
        builder.append(person +"'s Family"+ "\n");
        for(String v:map.get(person).keySet()){
            builder.append("       "+ v + "\n");
            for (FamilyMember p1: map.get(person).get(v)){
                builder.append("          * " + p1 + "\n");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private Collection checkRelatives(FamilyMember person){
        Collection values = map.get(person).values();
        return values;
    }

    public String displayFamilyMembers(){
        StringBuilder builder = new StringBuilder();
        for(FamilyMember mem : familyMembers){
            builder.append("* " + mem + "\n");
        }
        return builder.toString();
    }











}