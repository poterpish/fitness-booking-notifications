# Design Rationale

## Problem

This project is a Fitness Class Booking Notification System.

The system sends different types of notifications to fitness club members.
It supports booking confirmations and cancellation notifications.

Notifications can be delivered through different channels: email, app
notifications, or a legacy gym display system.

## Why Bridge?

The Bridge pattern separates notification types from delivery channels.

BookingNotification is the Abstraction.
BookingConfirmation and CancellationNotification are Refined Abstractions.

NotificationChannel is the Implementor interface.
EmailChannel, AppChannel, and LegacyDisplayAdapter are its implementations.

Because these two sides are separated, a new notification type or a new
delivery channel can be added without changing the existing classes.

## Why Adapter?

LegacyGymDisplay cannot implement NotificationChannel directly because it has
a different interface.

NotificationChannel uses:

send(String recipient, String message)

LegacyGymDisplay uses:

showMessage(byte[] message, int screenNumber, String memberCode)

The legacy system also returns integer error codes instead of using the
failure mechanism of the main application.

LegacyDisplayAdapter converts the parameters, calls LegacyGymDisplay, and
translates legacy failures into NotificationException.

## Why Both Patterns?

Bridge alone separates notification types from delivery channels, but it
cannot directly make the incompatible LegacyGymDisplay follow the
NotificationChannel contract.

Adapter alone can make LegacyGymDisplay compatible, but it does not separate
the notification hierarchy from the delivery-channel hierarchy.

Using both patterns solves both problems.

## Complexity Module

This project uses Dynamic Implementor Selection.

ChannelSelector selects EmailChannel, AppChannel, or LegacyDisplayAdapter at
runtime based on user input. The client works with NotificationChannel and
does not need to know the selected implementation.

## Limitation

The current ChannelSelector supports only predefined channel names.
Adding configuration from a database or external configuration file would
make the selection mechanism more flexible.