package com.orastays.propertyadd.service;

import java.util.List;

import com.orastays.propertadd.model.report.Graph;
import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.booking.BookingModel;
import com.orastays.propertyadd.model.booking.CancellationModel;

public interface ReportService {

	List<BookingModel> viewPropertyBookingList(BookingModel bookingModel) throws FormExceptions;
	List<BookingModel> viewUserBookingList(BookingModel bookingModel) throws FormExceptions;
	List<CancellationModel> viewPropertyCancellationList(BookingModel bookingModel) throws FormExceptions;
	List<CancellationModel> viewUserCancellationList(BookingModel bookingModel) throws FormExceptions;
	Object requestToiletry(PropertyModel propertyModel) throws FormExceptions;
	Graph fetchHostLineGraph(String userToken, String year) throws FormExceptions;
	Graph fetchHostBarGraph(String userToken, String year) throws FormExceptions;
}