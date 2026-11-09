/// Response models for the National Debt API.

/// API Response wrapper.
class NationaldebtResponse {
  final String status;
  final dynamic error;
  final NationaldebtData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  NationaldebtResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory NationaldebtResponse.fromJson(Map<String, dynamic> json) => NationaldebtResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? NationaldebtData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the National Debt API.

class NationaldebtData {
  String? date;
  String? recordDate;
  num? totalDebt;
  String? totalDebtFormatted;
  num? publicDebt;
  String? publicDebtFormatted;
  num? intragovernmentalDebt;
  String? intragovernmentalDebtFormatted;
  num? perCapita;
  String? perCapitaFormatted;
  num? population;
  num? publicDebtRatio;
  num? perHousehold;
  String? perHouseholdFormatted;
  num? previousDebt;
  String? previousDate;
  num? change1d;
  num? change30d;
  num? change1y;
  num? changePercent1y;
  num? averageDailyChange30d;

  NationaldebtData({
    this.date,
    this.recordDate,
    this.totalDebt,
    this.totalDebtFormatted,
    this.publicDebt,
    this.publicDebtFormatted,
    this.intragovernmentalDebt,
    this.intragovernmentalDebtFormatted,
    this.perCapita,
    this.perCapitaFormatted,
    this.population,
    this.publicDebtRatio,
    this.perHousehold,
    this.perHouseholdFormatted,
    this.previousDebt,
    this.previousDate,
    this.change1d,
    this.change30d,
    this.change1y,
    this.changePercent1y,
    this.averageDailyChange30d,
  });

  factory NationaldebtData.fromJson(Map<String, dynamic> json) => NationaldebtData(
      date: json['date'],
      recordDate: json['recordDate'],
      totalDebt: json['totalDebt'],
      totalDebtFormatted: json['totalDebtFormatted'],
      publicDebt: json['publicDebt'],
      publicDebtFormatted: json['publicDebtFormatted'],
      intragovernmentalDebt: json['intragovernmentalDebt'],
      intragovernmentalDebtFormatted: json['intragovernmentalDebtFormatted'],
      perCapita: json['perCapita'],
      perCapitaFormatted: json['perCapitaFormatted'],
      population: json['population'],
      publicDebtRatio: json['publicDebtRatio'],
      perHousehold: json['perHousehold'],
      perHouseholdFormatted: json['perHouseholdFormatted'],
      previousDebt: json['previousDebt'],
      previousDate: json['previousDate'],
      change1d: json['change1d'],
      change30d: json['change30d'],
      change1y: json['change1y'],
      changePercent1y: json['changePercent1y'],
      averageDailyChange30d: json['averageDailyChange30d'],
    );
}

class NationaldebtRequest {
  String? date;
  bool? changes;

  NationaldebtRequest({
    this.date,
    this.changes,
  });

  Map<String, dynamic> toJson() => {
      if (date != null) 'date': date,
      if (changes != null) 'changes': changes,
    };
}
