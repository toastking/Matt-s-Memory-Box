package delsig.android.mattsmemorybox2;

/**
 * Class to store groups on images, stored as ints
 * @author Matthew Del Signore
 */
import java.util.ArrayList;

public class PhotoSet {

	private ArrayList<Integer> photos = new ArrayList<Integer>();
	private String name;
	private String description;
	
	/**
	 * Constructor
	 * @param name The name of the PhotoSet
	 * @param desc A short descrition of what the photos are
	 */
	public PhotoSet(String name, String desc){
		this.name = name;
		this.description = desc;
	}
	
	/**
	 * Add a photo to the photoset
	 * @param resource Resource id of the imageResource
	 */
	public void addPhoto(int resource){
		photos.add(resource);
	}

	//Accessors/mutators
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getNumberOfPhotos(){
		return photos.size();
	}
	
	public int getPhoto(int index){
		return photos.get(index);
	}
	
	public ArrayList<Integer> getPhotosList(){
		return photos;
	}
}
