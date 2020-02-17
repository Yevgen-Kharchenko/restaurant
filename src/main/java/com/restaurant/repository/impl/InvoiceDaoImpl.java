package com.restaurant.repository.impl;

import com.restaurant.config.ConnectionFactory;
import com.restaurant.model.Invoice;
import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.repository.AbstractDao;
import com.restaurant.repository.EntityMapper;
import com.restaurant.repository.GetAllDao;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;

public class InvoiceDaoImpl extends AbstractDao<Invoice> implements GetAllDao<Invoice> {
    public InvoiceDaoImpl(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    private static final Logger LOG = Logger.getLogger(InvoiceDaoImpl.class);

    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_ORDER_ID = "orderId";
    private static final String COLUMN_STATUS = "status";
    private static final String SELECT_ALL_INVOICES = "SELECT * FROM `invoice`";
    private static final String SELECT_ALL_INVOICES_PAGINATED = "SELECT * FROM `invoice` LIMIT ?,?";
    private static final String SELECT_ALL_BY_ORDER_ID = "SELECT * FROM `invoice` WHERE orderId = ?";

    private static final String INSERT_INTO_INVOICE = "INSERT INTO `invoice` ("
            + COLUMN_DATE + ", "
            + COLUMN_ORDER_ID + ", "
            + COLUMN_STATUS + ") VALUE (?, ?, ?)";

    private static final String UPDATE_ORDER_DISH = "UPDATE `invoice` SET "
            + COLUMN_DATE + "= ?, "
            + COLUMN_ORDER_ID + "= ?, "
            + COLUMN_STATUS + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_ORDER_DISH = "DELETE FROM `invoice` "
            + "WHERE " + COLUMN_ID + " = ?";

    @Override
    public List<Invoice> getAll() {
        return getAll(SELECT_ALL_INVOICES, getMapper());
    }

    @Override
    public List<Invoice> getAllByFieldId(long id) {
        return getAllByField(SELECT_ALL_BY_ORDER_ID,
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public List<Invoice> getAllByField(String field) {
        return null;
    }

    @Override
    public List<Invoice> getAllPaginated(int page, int size) {
        int limit = (page - 1) * size;
        return getAll(SELECT_ALL_INVOICES_PAGINATED,
                ps -> {
                    ps.setInt(1, limit);
                    ps.setInt(2, size);
                },
                getMapper());
    }

    @Override
    public Invoice getById(long id) {
        return getByField("SELECT * FROM `invoice` WHERE id = ?",
                ps -> ps.setLong(1, id),
                getMapper());
    }

    @Override
    public Invoice create(Invoice entity) {
        LOG.info("Create invoice: + " + entity);
        long id = create(INSERT_INTO_INVOICE, ps -> {
            ps.setTimestamp(1, Timestamp.valueOf(entity.getDate()));
            ps.setLong(2, entity.getOrderId());
            ps.setString(3, entity.getInvoiceStatus().toString());
        });
        entity.setId(id);
        return entity;
    }

    @Override
    public boolean update(Invoice entity) {
        LOG.debug("Update OrderDish: " + entity);
        return update(UPDATE_ORDER_DISH, ps -> {
            ps.setTimestamp(1, Timestamp.valueOf(entity.getDate()));
            ps.setLong(2, entity.getOrderId());
            ps.setString(3, entity.getInvoiceStatus().toString());
            ps.setLong(4, entity.getId());
        });
    }

    @Override
    public boolean remove(Invoice entity) {
        LOG.debug("Delete Invoice: " + entity);
        return remove(DELETE_ORDER_DISH,
                ps -> ps.setLong(1, entity.getId()));
    }

    private EntityMapper<Invoice> getMapper() {
        return resultSet -> Invoice.builder()
                .id(resultSet.getLong(COLUMN_ID))
                .date(resultSet.getTimestamp(COLUMN_DATE).toLocalDateTime())
                .orderId(resultSet.getLong(COLUMN_ORDER_ID))
                .invoiceStatus(InvoiceStatus.valueOf(resultSet.getString(COLUMN_STATUS)))
                .build();
    }
}
