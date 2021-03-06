package com.zenixia.plugins.hexiagon.constants;

import com.zenixia.plugins.hexiagon.model.AnnouncementImage;
import com.zenixia.plugins.hexiagon.service.AnnouncementImageLocalServiceUtil;

public class AnnouncementConstants {
	
	private AnnouncementConstants() {
		super();
	}
	
	/**
	 * Image limit for an announcement
	 */
	public static final int IMAGE_LIMIT = 3;
	
	/**
	 * Max price for an announcement
	 */
	public static final long MAX_PRICE = 100000000000L;

	/**
	 * Announcement portlet repository
	 */
	public static final String ANNOUNCEMENT_PORTLET_REPOSITORY = "AnnouncementPortletRepository";
	
	/**
	 * Empty announcement Image for aui taglib
	 */
	public static final AnnouncementImage ANNOUNCEMENT_IMAGE = AnnouncementImageLocalServiceUtil.createAnnouncementImage(0L);

	/**
	 * Max image height for the resizing process 
	 */
	public static final int IMAGE_MAX_HEIGHT = 350;

	/**
	 * Max image width for the resizing process 
	 */
	public static final int IMAGE_MAX_WIDTH = 350;

	/**
	 * Max image size
	 */
	public static final long IMAGE_MAX_SIZE = 3000000L;

	/**
	 * Extensions
	 */
	public static final String IMAGE_EXTENSIONS = "gif,jpeg,jpg,png,tiff";
	
	/**
	 * Default delta search
	 */
	public static int DELDA_SEARCH = 10;
	
}
