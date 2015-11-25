package org.usfirst.frc.team115.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class AlphaBetaFilter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private double alpha; //alpha coefficient
	private double beta; //beta coefficient
	private double pX; //predicted x
	private double pV; //predicted v
	private double prevX; //previous predicted x
	private double prevV; //previous predicted v
	private double r; //residual
	private double interval; //time interval
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public AlphaBetaFilter(double alpha, double beta, double interval){
    	this(alpha, beta, 0, 0, interval);
    }
    
    public AlphaBetaFilter(double alpha, double beta, double x, double v, double interval){
    	super();
    	
    	this.alpha = alpha;
    	this.beta = beta;
    	pX = x;
    	pV = v;
    	this.interval = interval;
    }
    
    public void update(double x){
    	prevX = pX; //moving current to previous
    	prevV = pV; //same
    	    	
    	pX = prevX + prevV*interval; //predicted is previous plus estimated change
    	pV = prevV;
    	r = x - pX; //updating residual
    	pX = pX + alpha*r; //to account for residual
    	pV = pV + beta*r/interval; //same
    }
    
    public void setAlpha(double alpha){
    	this.alpha = alpha;
    }
    
    public void setBeta(double beta){
    	this.beta = beta;
    }
    
    
    /*
     * px = prevx + prevv*interval
     * pv = prevv
     * r = x - px
     * px = px + alpha*r
     * pv = pv + beta*r/interval
     * 
     */
    
    public double getPredictedX(){
    	return pX;
    }
    
    public double getPredictedV(){
    	return pV;
    }
}

