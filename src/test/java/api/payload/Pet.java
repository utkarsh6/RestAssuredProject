package api.payload;

import java.util.List;
public class Pet {
	 long id;
		Category category;
	    public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public List<Tag> getTags() {
			return tags;
		}
		public void setTags(List<Tag> tags) {
			this.tags = tags;
		}
		String name;
	    List<String> photoUrls;
	    List<Tag> tags;
	    String status;
	    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	    
	    public static class Category {
	        public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			long id;
	        String name;

	        
	    }
	    public static class Tag {
	        long id;
	        public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			String name;

	       
	    }
}

