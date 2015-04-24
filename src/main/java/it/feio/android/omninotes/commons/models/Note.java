/**
 * ****************************************************************************
 * Copyright 2014 Federico Iosue (federico.iosue@gmail.com)
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */
package it.feio.android.omninotes.commons.models;

import com.google.gson.Gson;
import it.feio.android.omninotes.commons.utils.EqualityChecker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Note implements Serializable {

	private String title;
	private String content;
	private Long creation;
	private Long lastModification;
	private Boolean archived;
	private Boolean trashed;
	private String alarm;
	private String recurrenceRule;
	private Double latitude;
	private Double longitude;
	private String address;
	private Category category;
	private Boolean locked;
	private Boolean checklist;
	private List<? extends Attachment> attachmentsList = new ArrayList<Attachment>();
	private List<? extends Attachment> attachmentsListOld = new ArrayList<Attachment>();


	public Note() {
		super();
		this.title = "";
		this.content = "";
		this.archived = false;
		this.trashed = false;
		this.locked = false;
		this.checklist = false;
	}


	public Note(Long creation, Long lastModification, String title, String content, Integer archived,
				Integer trashed, String alarm, String recurrenceRule, String latitude, String longitude, Category
						category, Integer locked, Integer checklist) {
		super();
		this.title = title;
		this.content = content;
		this.creation = creation;
		this.lastModification = lastModification;
		this.archived = archived == 1 ? true : false;
		this.trashed = trashed == 1 ? true : false;
		this.alarm = alarm;
		this.recurrenceRule = recurrenceRule;
		setLatitude(latitude);
		setLongitude(longitude);
		setAddress(address);
		setLocked(locked == 1 ? true : false);
		setChecklist(checklist == 1 ? true : false);
	}


	public Note(Note note) {
		super();
		buildFromNote(note);
	}


	private void buildFromNote(Note note) {
		setTitle(note.getTitle());
		setContent(note.getContent());
		setCreation(note.getCreation());
		setLastModification(note.getLastModification());
		setArchived(note.isArchived());
		setTrashed(note.isTrashed());
		setAlarm(note.getAlarm());
		setRecurrenceRule(note.getRecurrenceRule());
		setLatitude(note.getLatitude());
		setLongitude(note.getLongitude());
		setAddress(note.getAddress());
		setCategory(note.getCategory());
		setLocked(note.isLocked());
		setChecklist(note.isChecklist());
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		for (Attachment mAttachment : note.getAttachmentsList()) {
			list.add(mAttachment);
		}
		setAttachmentsList(list);
	}


	public void buildFromJson(String jsonNote) {
		Gson gson = new Gson();
		Note noteFromJson = gson.fromJson(jsonNote, this.getClass());
		buildFromNote(noteFromJson);
	}


	public void set_id(Long _id) {
		this.creation = _id;
	}


	public Long get_id() {
		return creation;
	}


	public String getTitle() {
		if (title == null) return "";
		return title;
	}


	public void setTitle(String title) {
		this.title = title == null ? "" : title;
	}


	public String getContent() {
		if (content == null) return "";
		return content;
	}


	public void setContent(String content) {
		this.content = content == null ? "" : content;
	}


	public Long getCreation() {
		return creation;
	}


	public void setCreation(Long creation) {
		this.creation = creation;
	}


	public void setCreation(String creation) {
		Long creationLong;
		try {
			creationLong = Long.parseLong(creation);
		} catch (NumberFormatException e) {
			creationLong = null;
		}
		this.creation = creationLong;
	}


	public Long getLastModification() {
		return lastModification;
	}


	public void setLastModification(Long lastModification) {
		this.lastModification = lastModification;
	}


	public void setLastModification(String lastModification) {
		Long lastModificationLong;
		try {
			lastModificationLong = Long.parseLong(lastModification);
		} catch (NumberFormatException e) {
			lastModificationLong = null;
		}
		this.lastModification = lastModificationLong;
	}


	public Boolean isArchived() {
		return archived == null || archived == false ? false : true;
	}


	public void setArchived(Boolean archived) {
		this.archived = archived;
	}


	public void setArchived(int archived) {
		this.archived = archived == 1 ? true : false;
	}


	public Boolean isTrashed() {
		return trashed == null || trashed == false ? false : true;
	}


	public void setTrashed(Boolean trashed) {
		this.trashed = trashed;
	}


	public void setTrashed(int trashed) {
		this.trashed = trashed == 1 ? true : false;
	}


	public String getAlarm() {
		return alarm;
	}


	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}


	public void setAlarm(long alarm) {
		this.alarm = String.valueOf(alarm);
	}


	public String getRecurrenceRule() {
		return recurrenceRule;
	}


	public void setRecurrenceRule(String recurrenceRule) {
		this.recurrenceRule = recurrenceRule;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public void setLatitude(String latitude) {
		try {
			setLatitude(Double.parseDouble(latitude));
		} catch (NumberFormatException e) {
			this.latitude = null;
		} catch (NullPointerException e) {
			this.latitude = null;
		}
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public void setLongitude(String longitude) {
		try {
			setLongitude(Double.parseDouble(longitude));
		} catch (NumberFormatException e) {
			this.longitude = null;
		} catch (NullPointerException e) {
			this.longitude = null;
		}
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Boolean isLocked() {
		return locked == null || locked == false ? false : true;
	}


	public void setLocked(Boolean locked) {
		this.locked = locked;
	}


	public void setLocked(int locked) {
		this.locked = locked == 1 ? true : false;
	}


	public Boolean isChecklist() {
		return checklist == null || checklist == false ? false : true;
	}


	public void setChecklist(Boolean checklist) {
		this.checklist = checklist;
	}


	public void setChecklist(int checklist) {
		this.checklist = checklist == 1 ? true : false;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<? extends Attachment> getAttachmentsList() {
		return attachmentsList;
	}


	public void setAttachmentsList(List<? extends Attachment> attachmentsList) {
		this.attachmentsList = attachmentsList;
	}


	public void backupAttachmentsList() {
		List<Attachment> attachmentsListOld = new ArrayList<Attachment>();
		for (Attachment mAttachment : getAttachmentsList()) {
			attachmentsListOld.add(mAttachment);
		}
		this.attachmentsListOld = attachmentsListOld;
	}


	public List<? extends Attachment> getAttachmentsListOld() {
		return attachmentsListOld;
	}


	public void setAttachmentsListOld(List<? extends Attachment> attachmentsListOld) {
		this.attachmentsListOld = attachmentsListOld;
	}


	public boolean equals(Object o) {
		boolean res = false;
		Note note;
		try {
			note = (Note) o;
		} catch (Exception e) {
			return res;
		}

		Object[] a = {getTitle(), getContent(), getCreation(), getLastModification(), isArchived(),
				isTrashed(), getAlarm(), getRecurrenceRule(), getLatitude(), getLongitude(), getAddress(), isLocked(),
				getCategory()};
		Object[] b = {note.getTitle(), note.getContent(), note.getCreation(),
				note.getLastModification(), note.isArchived(), note.isTrashed(), note.getAlarm(), note
				.getRecurrenceRule(), note.getLatitude(), note.getLongitude(), note.getAddress(), note.isLocked(),
				note.getCategory()};
		if (EqualityChecker.check(a, b)) {
			res = true;
		}

		return res;
	}


	public boolean isChanged(Note note) {
		boolean res = false;
		res = !equals(note) || !getAttachmentsList().equals(note.getAttachmentsList());
		return res;
	}


	public boolean isEmpty() {
		Note emptyNote = new Note();
		// Field to exclude for comparison
		emptyNote.setCreation(getCreation());
		emptyNote.setCategory(getCategory());
		// Check
		if (isChanged(emptyNote))
			return false;
		else return true;
	}


	public String toString() {
		return getTitle();
	}


	public String toJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
