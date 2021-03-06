package com.zenixia.plugins.hexiagon.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.zenixia.plugins.hexiagon.model.Currency;
import com.zenixia.plugins.hexiagon.model.CurrencyModel;
import com.zenixia.plugins.hexiagon.model.CurrencySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Currency service. Represents a row in the &quot;Hexiagon_Currency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.zenixia.plugins.hexiagon.model.CurrencyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CurrencyImpl}.
 * </p>
 *
 * @author guillaumelenoir
 * @see CurrencyImpl
 * @see com.zenixia.plugins.hexiagon.model.Currency
 * @see com.zenixia.plugins.hexiagon.model.CurrencyModel
 * @generated
 */
@JSON(strict = true)
public class CurrencyModelImpl extends BaseModelImpl<Currency>
    implements CurrencyModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a currency model instance should use the {@link com.zenixia.plugins.hexiagon.model.Currency} interface instead.
     */
    public static final String TABLE_NAME = "Hexiagon_Currency";
    public static final Object[][] TABLE_COLUMNS = {
            { "currencyId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "label", Types.VARCHAR },
            { "symbol", Types.VARCHAR },
            { "order_", Types.INTEGER },
            { "rate", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table Hexiagon_Currency (currencyId LONG not null primary key,companyId LONG,label VARCHAR(75) null,symbol VARCHAR(75) null,order_ INTEGER,rate LONG)";
    public static final String TABLE_SQL_DROP = "drop table Hexiagon_Currency";
    public static final String ORDER_BY_JPQL = " ORDER BY currency.order DESC";
    public static final String ORDER_BY_SQL = " ORDER BY Hexiagon_Currency.order_ DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.zenixia.plugins.hexiagon.model.Currency"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.zenixia.plugins.hexiagon.model.Currency"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.zenixia.plugins.hexiagon.model.Currency"));
    private static ClassLoader _classLoader = Currency.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Currency.class
        };
    private long _currencyId;
    private long _companyId;
    private String _label;
    private String _symbol;
    private int _order;
    private long _rate;
    private Currency _escapedModel;

    public CurrencyModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Currency toModel(CurrencySoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Currency model = new CurrencyImpl();

        model.setCurrencyId(soapModel.getCurrencyId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setLabel(soapModel.getLabel());
        model.setSymbol(soapModel.getSymbol());
        model.setOrder(soapModel.getOrder());
        model.setRate(soapModel.getRate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Currency> toModels(CurrencySoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Currency> models = new ArrayList<Currency>(soapModels.length);

        for (CurrencySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _currencyId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCurrencyId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _currencyId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Currency.class;
    }

    @Override
    public String getModelClassName() {
        return Currency.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("currencyId", getCurrencyId());
        attributes.put("companyId", getCompanyId());
        attributes.put("label", getLabel());
        attributes.put("symbol", getSymbol());
        attributes.put("order", getOrder());
        attributes.put("rate", getRate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long currencyId = (Long) attributes.get("currencyId");

        if (currencyId != null) {
            setCurrencyId(currencyId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        String label = (String) attributes.get("label");

        if (label != null) {
            setLabel(label);
        }

        String symbol = (String) attributes.get("symbol");

        if (symbol != null) {
            setSymbol(symbol);
        }

        Integer order = (Integer) attributes.get("order");

        if (order != null) {
            setOrder(order);
        }

        Long rate = (Long) attributes.get("rate");

        if (rate != null) {
            setRate(rate);
        }
    }

    @JSON
    @Override
    public long getCurrencyId() {
        return _currencyId;
    }

    @Override
    public void setCurrencyId(long currencyId) {
        _currencyId = currencyId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    @JSON
    @Override
    public String getLabel() {
        if (_label == null) {
            return StringPool.BLANK;
        } else {
            return _label;
        }
    }

    @Override
    public void setLabel(String label) {
        _label = label;
    }

    @JSON
    @Override
    public String getSymbol() {
        if (_symbol == null) {
            return StringPool.BLANK;
        } else {
            return _symbol;
        }
    }

    @Override
    public void setSymbol(String symbol) {
        _symbol = symbol;
    }

    @JSON
    @Override
    public int getOrder() {
        return _order;
    }

    @Override
    public void setOrder(int order) {
        _order = order;
    }

    @JSON
    @Override
    public long getRate() {
        return _rate;
    }

    @Override
    public void setRate(long rate) {
        _rate = rate;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Currency.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Currency toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Currency) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        CurrencyImpl currencyImpl = new CurrencyImpl();

        currencyImpl.setCurrencyId(getCurrencyId());
        currencyImpl.setCompanyId(getCompanyId());
        currencyImpl.setLabel(getLabel());
        currencyImpl.setSymbol(getSymbol());
        currencyImpl.setOrder(getOrder());
        currencyImpl.setRate(getRate());

        currencyImpl.resetOriginalValues();

        return currencyImpl;
    }

    @Override
    public int compareTo(Currency currency) {
        int value = 0;

        if (getOrder() < currency.getOrder()) {
            value = -1;
        } else if (getOrder() > currency.getOrder()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Currency)) {
            return false;
        }

        Currency currency = (Currency) obj;

        long primaryKey = currency.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<Currency> toCacheModel() {
        CurrencyCacheModel currencyCacheModel = new CurrencyCacheModel();

        currencyCacheModel.currencyId = getCurrencyId();

        currencyCacheModel.companyId = getCompanyId();

        currencyCacheModel.label = getLabel();

        String label = currencyCacheModel.label;

        if ((label != null) && (label.length() == 0)) {
            currencyCacheModel.label = null;
        }

        currencyCacheModel.symbol = getSymbol();

        String symbol = currencyCacheModel.symbol;

        if ((symbol != null) && (symbol.length() == 0)) {
            currencyCacheModel.symbol = null;
        }

        currencyCacheModel.order = getOrder();

        currencyCacheModel.rate = getRate();

        return currencyCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{currencyId=");
        sb.append(getCurrencyId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", label=");
        sb.append(getLabel());
        sb.append(", symbol=");
        sb.append(getSymbol());
        sb.append(", order=");
        sb.append(getOrder());
        sb.append(", rate=");
        sb.append(getRate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.zenixia.plugins.hexiagon.model.Currency");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>currencyId</column-name><column-value><![CDATA[");
        sb.append(getCurrencyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>label</column-name><column-value><![CDATA[");
        sb.append(getLabel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>symbol</column-name><column-value><![CDATA[");
        sb.append(getSymbol());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>order</column-name><column-value><![CDATA[");
        sb.append(getOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rate</column-name><column-value><![CDATA[");
        sb.append(getRate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
