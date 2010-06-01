package ch.unibe.inkml;

import org.w3c.dom.Element;

import ch.unibe.inkml.util.Formatter;
import ch.unibe.inkml.util.NumberFormatter;

public class InkChannelInteger extends InkChannel {

	public InkChannelInteger(InkInk ink) {
		super(ink);
	}

	public int defaultValue;
	public int max, min;
	
	/**
	 * {@inheritDoc}
	 */
    @Override
	public Formatter formatterFactory() {
		return new NumberFormatter(this);
	}

	@Override
	public Object getDefaultValue() {
		return (Object) this.defaultValue;
	}

	@Override
	public double getMax() throws InkMLComplianceException {
		return this.max;
	}

	@Override
	public double getMin() throws InkMLComplianceException {
		return this.min;
	}

	@Override
	public Object parse(String value) {
		return (Object) Integer.parseInt(value);
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		if(!defaultValue.equals("")){
			this.defaultValue = Integer.parseInt(defaultValue);
		}else{
			this.defaultValue = 0;
		}

	}
	public void setMax(String max) {
		if(!max.equals("")){
			this.max = Integer.parseInt(max);
			this.maxSet = true;
		}else{
			this.maxSet = false;
		}
	}

	@Override
	public void setMin(String min) {
		if(!min.equals("")){
			this.min = Integer.parseInt(min);
			this.minSet = true;
		}else{
			this.minSet = false;
		}
	}
	
	public Type getType() {
		return InkChannel.Type.INTEGER;
	}

	@Override
	protected void exportDefaultToInkML(Element c) {
		if(this.defaultValue != 0){
			c.setAttribute("default", Integer.toString(this.defaultValue));
		}
		
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public double doublize(Object o) {
        return (double)((Integer)o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object objectify(double d) {
        return (Object)((int)d);
    }

}
