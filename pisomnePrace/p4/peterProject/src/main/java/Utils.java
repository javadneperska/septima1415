import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Utils {
	
	public static boolean canBeCarried(List<Furniture> variation, double width, double height) {
		double sumHeight = 0, sumWidth = 0;
		for (Furniture f : variation) {
			sumHeight += f.getHeight();
			sumWidth += f.getWidth();
		}
		if (sumHeight <= height && sumWidth <= width) {
			return true;
		} else {
			return false;
		}
	}
	
	    public static Collection<List<Furniture>> generatePerm(Collection<Furniture> input) {
	        Collection<List<Furniture>> output = new ArrayList<List<Furniture>>();
	        if (input.isEmpty()) {
	            output.add(new ArrayList<Furniture>());
	            return output;
	        }
	        List<Furniture> list = new ArrayList<Furniture>(input);
	        Furniture head = list.get(0);
	        List<Furniture> rest = list.subList(1, list.size());
	        for (List<Furniture> permutations : generatePerm(rest)) {
	            List<List<Furniture>> subLists = new ArrayList<List<Furniture>>();
	            for (int i = 0; i <= permutations.size(); i++) {
	                List<Furniture> subList = new ArrayList<Furniture>();
	                subList.addAll(permutations);
	                subList.add(i, head);
	                subLists.add(subList);
	            }
	            output.addAll(subLists);
	        }
	        return output;
	    }
	    
	    public static ArrayList<ArrayList<Furniture>> permute(ArrayList<Furniture> num) {
            ArrayList<ArrayList<Furniture>> result = new ArrayList<ArrayList<Furniture>>();
         
            //start from an empty list
            result.add(new ArrayList<Furniture>());
         
            for (int i = 0; i < num.size(); i++) {
                //list of list in current iteration of the array num
                ArrayList<ArrayList<Furniture>> current = new ArrayList<ArrayList<Furniture>>();
         
                for (ArrayList<Furniture> l : result) {
                    // # of locations to insert is largest index + 1
                    for (int j = 0; j < l.size()+1; j++) {
                        // + add num[i] to different locations
                        l.add(j, num.get(i));
         
                        ArrayList<Furniture> temp = new ArrayList<Furniture>(l);
                        current.add(temp);
         
                        l.remove(j);
                    }
                }
         
                result = new ArrayList<ArrayList<Furniture>>(current);
            }
         
            return result;
        }
	}
