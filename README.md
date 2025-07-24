# PavtiPro - Digital Invoice Generator for Jewellery Retail

A lightweight Android tablet application designed for digital invoice creation and printing in jewellery retail settings.

## Overview

PavtiPro simplifies the invoice generation process for jewellery stores by replacing manual handwritten billing with a structured digital form. Staff can quickly input transaction details and generate professional invoices for customers.

## Features

### Core Functionality
- **Customer Information**: Name and auto-filled date
- **Item Details**: 
  - Gold color selection (Yellow, Rose, White, Yellow & White)
  - Item type (Ring, Necklace, Bracelet, Bangle, Earring)
  - Multi-select stone types (up to 3): Diamond, Ruby, Emerald, CZ, Sapphire
  - Design number selection
- **Measurements**: Lot number, carat, gram, stone weight
- **Amount**: Manual input for total amount
- **Invoice Preview**: Professional formatted invoice display

### Technical Features
- Tablet-optimized UI (landscape orientation)
- Touch-friendly interface for stylus or finger input
- Offline functionality (no internet required)
- Form validation and error handling
- Clean, branded invoice layout

## Target Platform
- **OS**: Android (API 24+)
- **Form Factor**: Tablets (10-inch and above)
- **Orientation**: Primarily landscape
- **Deployment**: APK format

## Project Structure

```
app/
├── src/main/
│   ├── java/com/pavtipro/invoice/
│   │   ├── MainActivity.kt              # Main form activity
│   │   ├── InvoicePreviewActivity.kt    # Invoice display activity
│   │   └── model/
│   │       └── InvoiceData.kt           # Data model
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml        # Main form layout
│   │   │   └── activity_invoice_preview.xml # Invoice preview layout
│   │   ├── values/
│   │   │   ├── colors.xml               # App colors
│   │   │   ├── strings.xml              # String resources
│   │   │   └── themes.xml               # App themes
│   │   └── drawable/
│   │       └── spinner_background.xml   # Spinner styling
│   └── AndroidManifest.xml
├── build.gradle                        # App-level build config
├── build.gradle                        # Project-level build config
└── settings.gradle                      # Project settings
```

## How to Use

1. **Launch the app** on your Android tablet
2. **Fill out the form**:
   - Enter customer name
   - Select gold color from dropdown
   - Choose item type
   - Select up to 3 stone types
   - Choose design number
   - Enter measurements (lot number, carat, gram, stone weight)
   - Enter total amount
3. **Generate Invoice** - tap the button to create the invoice
4. **Review** the formatted invoice on the preview screen
5. **Finish** to complete the transaction

## Build Instructions

1. Open the project in Android Studio
2. Sync Gradle files
3. Build and run on an Android tablet or emulator
4. For production: Generate signed APK via Build → Generate Signed Bundle/APK

## Requirements

- Android Studio Arctic Fox or later
- Android SDK API 24 or higher
- Kotlin support
- Target device: Android tablet

## Future Enhancements (Post-MVP)

- PDF generation and printing
- Email invoice to customer
- Invoice archive/history
- Basic customer record keeping
- Fingerprint/PIN unlock for staff
- Admin dashboard for dropdown management

## Benefits

- Digitizes manual, error-prone processes
- Speeds up customer checkout experience
- Reduces paper usage and improves professionalism
- Easy to train and use for non-technical staff
- Professional invoice presentation

## License

This project is designed for jewellery retail businesses to streamline their invoice generation process.