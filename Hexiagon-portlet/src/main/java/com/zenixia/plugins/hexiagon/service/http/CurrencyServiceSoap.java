package com.zenixia.plugins.hexiagon.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.zenixia.plugins.hexiagon.service.CurrencyServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.zenixia.plugins.hexiagon.service.CurrencyServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.zenixia.plugins.hexiagon.model.CurrencySoap}.
 * If the method in the service utility returns a
 * {@link com.zenixia.plugins.hexiagon.model.Currency}, that is translated to a
 * {@link com.zenixia.plugins.hexiagon.model.CurrencySoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author guillaumelenoir
 * @see CurrencyServiceHttp
 * @see com.zenixia.plugins.hexiagon.model.CurrencySoap
 * @see com.zenixia.plugins.hexiagon.service.CurrencyServiceUtil
 * @generated
 */
public class CurrencyServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(CurrencyServiceSoap.class);

    public static com.zenixia.plugins.hexiagon.model.CurrencySoap addCurrency(
        com.zenixia.plugins.hexiagon.model.CurrencySoap currency,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.hexiagon.model.Currency returnValue = CurrencyServiceUtil.addCurrency(com.zenixia.plugins.hexiagon.model.impl.CurrencyModelImpl.toModel(
                        currency), serviceContext);

            return com.zenixia.plugins.hexiagon.model.CurrencySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.hexiagon.model.CurrencySoap updateCurrency(
        com.zenixia.plugins.hexiagon.model.CurrencySoap currency)
        throws RemoteException {
        try {
            com.zenixia.plugins.hexiagon.model.Currency returnValue = CurrencyServiceUtil.updateCurrency(com.zenixia.plugins.hexiagon.model.impl.CurrencyModelImpl.toModel(
                        currency));

            return com.zenixia.plugins.hexiagon.model.CurrencySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.zenixia.plugins.hexiagon.model.CurrencySoap deleteCurrency(
        long currencyId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.zenixia.plugins.hexiagon.model.Currency returnValue = CurrencyServiceUtil.deleteCurrency(currencyId,
                    serviceContext);

            return com.zenixia.plugins.hexiagon.model.CurrencySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
