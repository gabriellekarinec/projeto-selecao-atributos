package model;

public class Book {
	
	private String id;
	private String author;
	private String volume;
	private String title;
	private String institution;
	private String venue;
	private String address;
	private String publisher;
	private String year;
	private String pages;
	private String editor;
	private String note;
	private String month;
	private String classe;
        private int schemaNumber;
	
	
		
	public Book(String id, String author,	String volume,	String title,	String institution,	String venue,
			String address,	String publisher,	String year,	String pages,	String editor,	String note,
			String month,	String classe, int schemaNumber){
		
		this.id = id;
		this.author = author;
		this.volume = volume;
		this.title = title;
                this.institution = institution;
                this.venue = venue;
                this.address = address;
                this.publisher = publisher;
                this.year = year;
                this.pages = pages;
                this.editor = editor;
                this.month = month;
                this.note = note;
                this.classe = classe;
                this.schemaNumber = schemaNumber;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getEditor() {
        return editor;
    }
    
    public String get(String att){
        String retorno = null;
        
        if(att.equals("id")){
            retorno = getId();
        }else if(att.equals("author")){
            retorno = getAuthor();
        }else if(att.equals("volume")){
            retorno = getVolume();
        }else if(att.equals("title")){
            retorno = getTitle();
        }else if(att.equals("institution")){
            retorno = getInstitution();
        }else if(att.equals("venue")){
            retorno = getVenue();
        }else if(att.equals("address")){
            retorno = getAddress();
        }else if(att.equals("publisher")){
            retorno = getPublisher();
        }else if(att.equals("year")){
            retorno = getYear();
        }else if(att.equals("pages")){
            retorno = getPages();
        }else if(att.equals("editor")){
            retorno = getEditor();
        }else if(att.equals("note")){
            retorno = getNote();
        }else if(att.equals("month")){
            retorno = getMonth();
        }else if(att.equals("classe")){
            retorno = getClasse();
        }
        
        return retorno;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
        
    public int getSchemaNumber(){
      return this.schemaNumber;  
    }
      
}
