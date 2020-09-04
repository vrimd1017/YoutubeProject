package domain.Object;

import com.google.gson.annotations.SerializedName;

public class ThumbnailObjects {
	
	@SerializedName(value="default")
	private ThumbnailObject base;
	
	private ThumbnailObject medium;
	private ThumbnailObject high;
	private ThumbnailObject standard;
	private ThumbnailObject maxres;
	
	public ThumbnailObject getBase() {
		return base;
	}
	public void setBase(ThumbnailObject base) {
		this.base = base;
	}
	public ThumbnailObject getMedium() {
		return medium;
	}
	public void setMedium(ThumbnailObject medium) {
		this.medium = medium;
	}
	public ThumbnailObject getHigh() {
		return high;
	}
	public void setHigh(ThumbnailObject high) {
		this.high = high;
	}
	public ThumbnailObject getStandard() {
		return standard;
	}
	public void setStandard(ThumbnailObject standard) {
		this.standard = standard;
	}
	public ThumbnailObject getMaxres() {
		return maxres;
	}
	public void setMaxres(ThumbnailObject maxres) {
		this.maxres = maxres;
	}
	
	
	
}
