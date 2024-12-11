package com.app.coffee.Backend.Service;

import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.Model.ControlModel;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.Backend.Model.WorkingTimeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControlService {

    public List<ControlModel> getAllControls() {
        List<ControlModel> controlList = new ArrayList<>();
        String sql = "SELECT c.control_id, c.check_in, c.check_out, c.check_in_pay, c.check_out_pay, c.created_at, c.updated_at, " +
                     "a.account_id, a.username, " +
                     "w.working_time_id, w.name, " +
                     "c.staff_list " + // Thêm cột staff_list
                     "FROM control c " +
                     "JOIN account a ON c.account_id = a.account_id " +
                     "JOIN working_time w ON c.working_time_id = w.working_time_id " +
                     "ORDER BY c.control_id DESC";

        try (Connection connection = ConnectionCoffee.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int controlId = rs.getInt("control_id");
                LocalDateTime checkIn = rs.getTimestamp("check_in").toLocalDateTime();
                LocalDateTime checkOut = rs.getTimestamp("check_out").toLocalDateTime();
                float checkInPay = rs.getFloat("check_in_pay");
                float checkOutPay = rs.getFloat("check_out_pay");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();

                int accountId = rs.getInt("account_id");
                String username = rs.getString("username");

                UsersModel userModel = new UsersModel();
                userModel.setAccount_id(accountId);
                userModel.setUserName(username);

                int workingTimeId = rs.getInt("working_time_id");
                String workingTimeName = rs.getString("name");

                WorkingTimeModel workingTimeModel = new WorkingTimeModel();
                workingTimeModel.setWorkingTimeId(workingTimeId);
                workingTimeModel.setName(workingTimeName);

                String staffList = rs.getString("staff_list"); // Lấy giá trị staff_list

                ControlModel controlModel = new ControlModel(controlId, workingTimeModel, checkIn, checkOut, checkInPay, checkOutPay, userModel,staffList, createdAt, updatedAt);
                controlModel.setStaffList(staffList); // Gán giá trị staff_list
                controlList.add(controlModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return controlList;
    }

    public List<ControlModel> getControlsByDate(LocalDateTime date) {
        List<ControlModel> controlList = new ArrayList<>();
        String sql = "SELECT c.control_id, c.check_in, c.check_out, c.check_in_pay, c.check_out_pay, c.created_at, c.updated_at, " +
                     "a.account_id, a.username, " +
                     "w.working_time_id, w.name, " +
                     "c.staff_list " + // Thêm cột staff_list
                     "FROM control c " +
                     "JOIN account a ON c.account_id = a.account_id " +
                     "JOIN working_time w ON c.working_time_id = w.working_time_id " +
                     "WHERE DATE(c.check_in) = ? " +
                     "ORDER BY c.control_id DESC";

        try (Connection connection = ConnectionCoffee.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, date.toLocalDate());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int controlId = rs.getInt("control_id");
                    LocalDateTime checkIn = rs.getTimestamp("check_in").toLocalDateTime();
                    LocalDateTime checkOut = rs.getTimestamp("check_out").toLocalDateTime();
                    float checkInPay = rs.getFloat("check_in_pay");
                    float checkOutPay = rs.getFloat("check_out_pay");
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();

                    int accountId = rs.getInt("account_id");
                    String username = rs.getString("username");

                    UsersModel userModel = new UsersModel();
                    userModel.setAccount_id(accountId);
                    userModel.setUserName(username);

                    int workingTimeId = rs.getInt("working_time_id");
                    String workingTimeName = rs.getString("name");

                    WorkingTimeModel workingTimeModel = new WorkingTimeModel();
                    workingTimeModel.setWorkingTimeId(workingTimeId);
                    workingTimeModel.setName(workingTimeName);

                    String staffList = rs.getString("staff_list"); // Lấy giá trị staff_list

                    ControlModel controlModel = new ControlModel(controlId, workingTimeModel, checkIn, checkOut, checkInPay, checkOutPay, userModel,staffList, createdAt, updatedAt);
                    controlModel.setStaffList(staffList); // Gán giá trị staff_list
                    controlList.add(controlModel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return controlList;
    }

    public List<ControlModel> getControlsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<ControlModel> controlList = new ArrayList<>();
        String sql = "SELECT c.control_id, c.check_in, c.check_out, c.check_in_pay, c.check_out_pay, c.created_at, c.updated_at, " +
                     "a.account_id, a.username, " +
                     "w.working_time_id, w.name, " +
                     "c.staff_list " + // Thêm cột staff_list
                     "FROM control c " +
                     "JOIN account a ON c.account_id = a.account_id " +
                     "JOIN working_time w ON c.working_time_id = w.working_time_id " +
                     "WHERE DATE(c.check_in) BETWEEN ? AND ? " +
                     "ORDER BY c.control_id DESC";

        try (Connection connection = ConnectionCoffee.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, startDate);
            ps.setObject(2, endDate);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int controlId = rs.getInt("control_id");
                    LocalDateTime checkIn = rs.getTimestamp("check_in").toLocalDateTime();
                    LocalDateTime checkOut = rs.getTimestamp("check_out").toLocalDateTime();
                    float checkInPay = rs.getFloat("check_in_pay");
                    float checkOutPay = rs.getFloat("check_out_pay");
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();

                    int accountId = rs.getInt("account_id");
                    String username = rs.getString("username");

                    UsersModel userModel = new UsersModel();
                    userModel.setAccount_id(accountId);
                    userModel.setUserName(username);

                    int workingTimeId = rs.getInt("working_time_id");
                    String workingTimeName = rs.getString("name");

                    WorkingTimeModel workingTimeModel = new WorkingTimeModel();
                    workingTimeModel.setWorkingTimeId(workingTimeId);
                    workingTimeModel.setName(workingTimeName);

                    String staffList = rs.getString("staff_list"); // Lấy giá trị staff_list

                    ControlModel controlModel = new ControlModel(controlId, workingTimeModel, checkIn, checkOut, checkInPay, checkOutPay, userModel,staffList, createdAt, updatedAt);
                    controlModel.setStaffList(staffList); // Gán giá trị staff_list
                    controlList.add(controlModel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return controlList;
    }
}
