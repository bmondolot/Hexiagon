package com.zenixia.plugins.hexiagon.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.util.DLProcessorRegistryUtil;
import com.zenixia.plugins.hexiagon.constants.AnnouncementConstants;
import com.zenixia.plugins.hexiagon.model.AnnouncementImage;
import com.zenixia.plugins.hexiagon.service.base.AnnouncementImageLocalServiceBaseImpl;

import java.io.InputStream;
import java.util.List;

/**
 * The implementation of the announcement image local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.glenoir.plugins.hexagon.service.AnnouncementImageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.zenixia.plugins.hexiagon.hexagon.service.base.AnnouncementImageLocalServiceBaseImpl
 * @see com.glenoir.plugins.hexagon.service.AnnouncementImageLocalServiceUtil
 */
public class AnnouncementImageLocalServiceImpl
    extends AnnouncementImageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.glenoir.plugins.hexagon.service.AnnouncementImageLocalServiceUtil} to access the announcement image local service.
     */
	
	private static Log LOGGER = LogFactoryUtil.getLog(AnnouncementImageLocalServiceImpl.class);

	public AnnouncementImage addAnnouncementImage(AnnouncementImage announcementImage, long annoucementFolderId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		InputStream imageInputStream = announcementImage.getInputStream();
		long groupId = announcementImage.getGroupId();
		long userId = announcementImage.getUserId();

		if (announcementImage.isNew() && Validator.isNotNull(imageInputStream)) {
			announcementImage.setAnnouncementImageId(CounterLocalServiceUtil.increment(AnnouncementImage.class.getName()));

			try {
				
	    		// Add image in the announcement repository portlet
				FileEntry imageFileEntry = PortletFileRepositoryUtil.addPortletFileEntry(
				groupId, userId, AnnouncementImage.class.getName(),announcementImage.getAnnouncementImageId(),
				AnnouncementConstants.ANNOUNCEMENT_PORTLET_REPOSITORY,
				annoucementFolderId, imageInputStream,
				String.valueOf(announcementImage.getAnnouncementImageId()), StringPool.BLANK, true);
				DLProcessorRegistryUtil.trigger(imageFileEntry, null, true);
				
				// Set new file entryId
				announcementImage.setFileEntryId(imageFileEntry.getFileEntryId());
				
				// Add announcement image
				announcementImage = super.addAnnouncementImage(announcementImage);
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("SystemException : impossible to add announcement image with file entry " + announcementImage.getFileEntryId());
				LOGGER.error(e.getMessage());
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException : impossible to add announcement image with file entry " + announcementImage.getFileEntryId());
				LOGGER.error(e.getMessage());
			}
		}
		
		return announcementImage;
	}

	public List<AnnouncementImage> getAnnouncementImageByAnnouncementId(long announcementId)
		throws SystemException {

		return announcementImagePersistence.findByG_A(announcementId);
	}
	
	public AnnouncementImage getAnnouncementImageByAnnouncementIdOrder(long announcementId, int order)
		throws SystemException {
	
		return announcementImagePersistence.fetchByA_O(announcementId, order);
	}


	public AnnouncementImage deleteAnnouncementImage(AnnouncementImage announcementImage)
		throws SystemException, PortalException {

		long fileEntryId = announcementImage.getFileEntryId();
		
		if (Validator.isNotNull(fileEntryId)) {
			try {
				PortletFileRepositoryUtil.deletePortletFileEntry(fileEntryId);
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("SystemException : impossible to delete announcement image with file entry " + announcementImage.getFileEntryId());
				LOGGER.error(e.getMessage());
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException : impossible to delete announcement image with file entry " + announcementImage.getFileEntryId());
				LOGGER.error(e.getMessage());
			}
		}
		
		return super.deleteAnnouncementImage(announcementImage);	}

	public AnnouncementImage updateAnnouncementImage(AnnouncementImage announcementImage,long annoucementFolderId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		InputStream imageInputStream = announcementImage.getInputStream();
		long groupId = announcementImage.getGroupId();
		long userId = announcementImage.getUserId();
		long announcementImageId = announcementImage.getAnnouncementImageId();
		long fileEntryId = announcementImage.getFileEntryId();
		
		if (Validator.isNotNull(imageInputStream)) {
			try {
				// Delete old file Entry
				PortletFileRepositoryUtil.deletePortletFileEntry(fileEntryId);
				
				// Add image in the announcement repository portlet
				FileEntry imageFileEntry = PortletFileRepositoryUtil.addPortletFileEntry(
				groupId, userId, AnnouncementImage.class.getName(),announcementImageId,
				AnnouncementConstants.ANNOUNCEMENT_PORTLET_REPOSITORY,
				annoucementFolderId, imageInputStream,
				String.valueOf(announcementImageId), StringPool.BLANK, true);
				DLProcessorRegistryUtil.trigger(imageFileEntry, null, true);
				
				// Set new file entryId
				announcementImage.setFileEntryId(imageFileEntry.getFileEntryId());
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("SystemException : impossible to update announcement image with file entry " + announcementImage.getFileEntryId());
				LOGGER.error(e.getMessage());
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException : impossible to update announcement image with file entry " + announcementImage.getFileEntryId());
				LOGGER.error(e.getMessage());
			}
		}
		
		// Update announcement image
				
		return super.updateAnnouncementImage(announcementImage);
	}
}
