package algorithm.sort;

import java.util.LinkedList;
import java.util.Stack;
public class SimplifyPathB {

	

	import java.util.LinkedList;
	import java.util.Stack;

	/**
	 * Simplify Path 
	 *
	 *Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	click to show corner cases.

	Corner Cases:
	Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".
	 */
	

		public static void main(String args[]) {
			String path = "/home//foo/";
			System.out.println(simplifyPath(path));
		}

		public static String simplifyPath(String path) {
			if(path.length() == 0){
				return path;
			}
			
			String[] splits = path.split("/");
			LinkedList<String> stack = new LinkedList<String>();
			for (String s : splits) {
				if(s.length()==0 || s.equals(".")){
					continue;
				}else if(s.equals("..")){
					if(!stack.isEmpty()){
						stack.pop();
					}
				}else{
					stack.push(s);
				}
			}
			
			if(stack.isEmpty()){
				stack.push("");
			}
			String ret = "";
			while(!stack.isEmpty()){
				ret += "/" + stack.removeLast();
			}
			
			return ret;
		}
		
	}
}
