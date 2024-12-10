
package week2;
import java.util.*;

import java.util.Scanner;

// My mic is bad, so I can't talk.
class incompLensConfigException extends Exception{
	incompLensConfigException(String msg){
		super(msg);
	}
}
//let's first create the lens 
class obj{
	private String type;
	private float v;
	private float h;
	obj(String tp,float dist,float height){
		this.type=tp;
		this.v=dist;
		this.h=height;
	}
	float getHeight() {
		return this.h;
	}
	String getType() {
		return this.type;
	}
	float getDistance(){
		return this.v;
	}
}
class lens{
	//it can be concave and convex
	private String type;
	//it's focal length
	private float foc;
	//that's all is needed for the lens
	
	lens(String tp,float foc) throws incompLensConfigException{
		this.type=tp;
		this.foc=foc;
		if (type!="concave"| type!="convex") {
			throw new incompLensConfigException("type should be 'concave' or 'convex' (Atleast at this moment)");
		}
		if (foc==0) {
			throw new incompLensConfigException("That's just a plain stupid");
		}
		if (foc <0 & type=="concave") {
			throw new incompLensConfigException("Invalid type or focal length");
		}
		if (foc >0 & type=="convex") {
			throw new incompLensConfigException("Invalid type or focal length");
		}
		// I don't find other reasons to raise exceptions rn
	}
	
	//lens has one function. it takes an object and gives out an image 
	//it needs a 'u' (Object distance) and 'f' to calculate 'v'
	public obj refract(obj o,float u) {
		if (u>0) {
			
		}
		if (this.type=="concave") {
			//this produces a virtual image, that is shrunk
			float v=-1* (this.foc*u)/(this.foc + u);
			float h=(v/u)*(o.getHeight());
			return new obj("virtual",v,h);
		}
		else {
			float v=-1* (this.foc*u)/(this.foc - u);
			float h=(v/u)*(o.getHeight());
			if (u<this.foc){
				//this is a virtual image
				return new obj("virtual",v,h);
			}
			return new obj("real",v,h);
		}
	}
}

class ref{
	//this is the complete set
	
	ref(){
	}
}
