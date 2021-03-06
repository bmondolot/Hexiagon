package com.zenixia.plugins.hexiagon.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.zenixia.plugins.hexiagon.model.Announcement;
import com.zenixia.plugins.hexiagon.permission.AnnouncementPermission;
import com.zenixia.plugins.hexiagon.permission.HexiagonPermission;
import com.zenixia.plugins.hexiagon.service.base.AnnouncementServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the announcement remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.glenoir.plugins.hexagon.service.AnnouncementService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.zenixia.plugins.hexiagon.hexagon.service.base.AnnouncementServiceBaseImpl
 * @see com.glenoir.plugins.hexagon.service.AnnouncementServiceUtil
 */
public class AnnouncementServiceImpl extends AnnouncementServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.glenoir.plugins.hexagon.service.AnnouncementServiceUtil} to access the announcement remote service.
     */
	
	public Announcement addAnnouncement(Announcement announcement, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		HexiagonPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_ANNOUNCEMENT");

		return announcementLocalService.addAnnouncement(announcement, serviceContext);
	}

	public Announcement updateAnnouncement(Announcement announcement, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		AnnouncementPermission.check(getPermissionChecker(), announcement.getAnnouncementId(), ActionKeys.UPDATE);

		return announcementLocalService.updateAnnouncement(announcement, serviceContext);
	}

	public Announcement deleteAnnouncement(long announcementId)
		throws SystemException, PrincipalException, PortalException {

		AnnouncementPermission.check(getPermissionChecker(), announcementId, ActionKeys.DELETE);

		return announcementLocalService.deleteAnnouncement(announcementId);
	}

	public Announcement getAnnouncement(long announcementId)
		throws SystemException, PortalException {

		AnnouncementPermission.check(getPermissionChecker(), announcementId, ActionKeys.VIEW);
		return announcementLocalService.getAnnouncement(announcementId);
	}
	
	public List<Announcement> getAnnouncementsByGroupId(long groupId, int start, int end) throws SystemException {
		return announcementPersistence.filterFindByGroupId(groupId, start, end);	
	}
	
	public int getAnnouncementsCountByGroupId(long groupId) throws SystemException {
		return announcementPersistence.filterCountByGroupId(groupId);	
	}
}
