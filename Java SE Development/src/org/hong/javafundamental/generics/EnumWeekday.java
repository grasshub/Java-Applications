package org.hong.javafundamental.generics;

public class EnumWeekday {
    Day day;
    
    public EnumWeekday(Day day) {
        this.day = day;
    }
    
    public void tellItLikeItIs() {
    	
    	if (day != Day.MONDAY)
    		System.out.println(day);
    		
    	if(day.equals(Day.MONDAY))
    		System.out.println(day);
    	
    	
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
    
    public static void main(String[] args) {
        EnumWeekday firstDay = new EnumWeekday(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumWeekday thirdDay = new EnumWeekday(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumWeekday fifthDay = new EnumWeekday(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumWeekday sixthDay = new EnumWeekday(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumWeekday seventhDay = new EnumWeekday(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
