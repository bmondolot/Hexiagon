package com.zenixia.plugins.hexiagon.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FavoriteLocalService}.
 *
 * @author guillaumelenoir
 * @see FavoriteLocalService
 * @generated
 */
public class FavoriteLocalServiceWrapper implements FavoriteLocalService,
    ServiceWrapper<FavoriteLocalService> {
    private FavoriteLocalService _favoriteLocalService;

    public FavoriteLocalServiceWrapper(
        FavoriteLocalService favoriteLocalService) {
        _favoriteLocalService = favoriteLocalService;
    }

    /**
    * Adds the favorite to the database. Also notifies the appropriate model listeners.
    *
    * @param favorite the favorite
    * @return the favorite that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite addFavorite(
        com.zenixia.plugins.hexiagon.model.Favorite favorite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.addFavorite(favorite);
    }

    /**
    * Creates a new favorite with the primary key. Does not add the favorite to the database.
    *
    * @param favoriteId the primary key for the new favorite
    * @return the new favorite
    */
    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite createFavorite(
        long favoriteId) {
        return _favoriteLocalService.createFavorite(favoriteId);
    }

    /**
    * Deletes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param favoriteId the primary key of the favorite
    * @return the favorite that was removed
    * @throws PortalException if a favorite with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite deleteFavorite(
        long favoriteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.deleteFavorite(favoriteId);
    }

    /**
    * Deletes the favorite from the database. Also notifies the appropriate model listeners.
    *
    * @param favorite the favorite
    * @return the favorite that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite deleteFavorite(
        com.zenixia.plugins.hexiagon.model.Favorite favorite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.deleteFavorite(favorite);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _favoriteLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.hexiagon.model.impl.FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.hexiagon.model.impl.FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite fetchFavorite(
        long favoriteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.fetchFavorite(favoriteId);
    }

    /**
    * Returns the favorite with the primary key.
    *
    * @param favoriteId the primary key of the favorite
    * @return the favorite
    * @throws PortalException if a favorite with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite getFavorite(
        long favoriteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.getFavorite(favoriteId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the favorites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.zenixia.plugins.hexiagon.model.impl.FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of favorites
    * @param end the upper bound of the range of favorites (not inclusive)
    * @return the range of favorites
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.zenixia.plugins.hexiagon.model.Favorite> getFavorites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.getFavorites(start, end);
    }

    /**
    * Returns the number of favorites.
    *
    * @return the number of favorites
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getFavoritesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.getFavoritesCount();
    }

    /**
    * Updates the favorite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param favorite the favorite
    * @return the favorite that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite updateFavorite(
        com.zenixia.plugins.hexiagon.model.Favorite favorite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.updateFavorite(favorite);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _favoriteLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _favoriteLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _favoriteLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.zenixia.plugins.hexiagon.model.Favorite addUserFavoriteAnnouncement(
        long announcementId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.addUserFavoriteAnnouncement(announcementId,
            serviceContext);
    }

    @Override
    public void removeUserFavoriteAnnouncement(long announcementId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.SystemException {
        _favoriteLocalService.removeUserFavoriteAnnouncement(announcementId,
            serviceContext);
    }

    @Override
    public boolean isUserFavoriteAnnouncement(long userId, long announcementId,
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.isUserFavoriteAnnouncement(userId,
            announcementId, groupId);
    }

    @Override
    public int countUserFavoriteAnnouncement(long userId, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _favoriteLocalService.countUserFavoriteAnnouncement(userId,
            groupId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FavoriteLocalService getWrappedFavoriteLocalService() {
        return _favoriteLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFavoriteLocalService(
        FavoriteLocalService favoriteLocalService) {
        _favoriteLocalService = favoriteLocalService;
    }

    @Override
    public FavoriteLocalService getWrappedService() {
        return _favoriteLocalService;
    }

    @Override
    public void setWrappedService(FavoriteLocalService favoriteLocalService) {
        _favoriteLocalService = favoriteLocalService;
    }
}