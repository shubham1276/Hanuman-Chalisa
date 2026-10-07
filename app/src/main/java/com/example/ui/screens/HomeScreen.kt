package com.example.ui.screens

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.AppPreferences
import com.example.data.AppThemeMode
import com.example.data.ChalisaData
import com.example.ui.theme.SacredGold
import com.example.ui.theme.SaffronPrimary

@Composable
fun HomeScreen(
    preferences: AppPreferences,
    onNavigateToRead: (initialVerse: Int) -> Unit,
    onNavigateToListen: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToJaap: () -> Unit
) {
    val context = LocalContext.current
    val lastVerse = ChalisaData.getVerse(preferences.lastReadVerseIndex)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Top Quick Bar: Devotional Chant & Theme Switcher
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.4f))
                ) {
                    Text(
                        text = "॥ ॐ हनुमते नमः ॥",
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                }

                IconButton(
                    onClick = {
                        val nextMode = when (preferences.themeMode) {
                            AppThemeMode.LIGHT -> AppThemeMode.SOFT_DARK
                            AppThemeMode.SOFT_DARK -> AppThemeMode.LIGHT
                            AppThemeMode.SYSTEM -> AppThemeMode.SOFT_DARK
                        }
                        preferences.updateThemeMode(nextMode)
                    },
                    modifier = Modifier.testTag("theme_toggle_btn")
                ) {
                    Icon(
                        imageVector = if (preferences.themeMode == AppThemeMode.SOFT_DARK) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Toggle Light/Dark Theme",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sacred Hanuman Ji Emblem / Hero Art
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .shadow(12.dp, CircleShape)
                    .clip(CircleShape)
                    .border(3.dp, SacredGold, CircleShape)
                    .background(
                        Brush.radialGradient(
                            listOf(
                                SacredGold.copy(alpha = 0.3f),
                                SaffronPrimary.copy(alpha = 0.8f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_hanuman_hero),
                    contentDescription = "Lord Hanuman devotional portrait",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Divine Title
            Text(
                text = "श्री हनुमान चालीसा",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                ),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Shri Hanuman Chalisa",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.5.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "जय श्री राम • संकटमोचन",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SacredGold
                )
            )

            Spacer(modifier = Modifier.height(18.dp))

            // "Continue where you left off" Card (if user previously read)
            AnimatedVisibility(
                visible = preferences.lastReadVerseIndex > 0,
                enter = fadeIn()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 600.dp)
                        .padding(bottom = 16.dp)
                        .clickable { onNavigateToRead(preferences.lastReadVerseIndex) },
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SacredGold.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Bookmark,
                                contentDescription = "Last read",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "जहाँ छोड़ा था वहीं से पढ़ें (Continue)",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "${lastVerse.numberTitleHindi} (${lastVerse.numberTitle})",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = FontWeight.SemiBold
                                    ),
                                    maxLines = 1
                                )
                            }
                        }

                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Resume",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }

            // ==========================================
            // CORE 3 LARGE PROMINENT BUTTONS (Requirement 1)
            // ==========================================
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // BUTTON 1: READ CHALISA
                BigMenuButton(
                    titleHindi = "चालीसा पढ़ें",
                    titleEnglish = "Read Chalisa",
                    subtitle = "सम्पूर्ण दोहा एवं ४० चौपाई अर्थ सहित",
                    icon = Icons.Default.MenuBook,
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    testTag = "home_btn_read",
                    onClick = { onNavigateToRead(0) }
                )

                // BUTTON 2: LISTEN (AUDIO)
                BigMenuButton(
                    titleHindi = "ऑडियो सुनें",
                    titleEnglish = "Listen to Chalisa",
                    subtitle = "भक्तिमय पाठ • श्लोक हाइलाइटिंग के साथ",
                    icon = Icons.Default.Headphones,
                    backgroundColor = SacredGold,
                    contentColor = Color.White,
                    testTag = "home_btn_listen",
                    onClick = onNavigateToListen
                )

                // BUTTON 3: SETTINGS
                BigMenuButton(
                    titleHindi = "सेटिंग्स व भाषा",
                    titleEnglish = "Settings & Text Size",
                    subtitle = "फॉन्ट साइज़ (बड़ा/छोटा) एवं भाषा चयन",
                    icon = Icons.Default.Settings,
                    backgroundColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    isOutlined = true,
                    borderColor = SacredGold.copy(alpha = 0.6f),
                    testTag = "home_btn_settings",
                    onClick = onNavigateToSettings
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ==========================================
            // EXTRAS (Requirement 6 - Subtle & Clean)
            // ==========================================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // JAAP COUNTER BUTTON
                OutlinedButton(
                    onClick = onNavigateToJaap,
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .testTag("home_btn_jaap"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, SacredGold.copy(alpha = 0.5f))
                ) {
                    Icon(
                        imageVector = Icons.Default.SelfImprovement,
                        contentDescription = "Jaap Counter",
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (preferences.jaapCount > 0) "जाप माला (${preferences.jaapCount})" else "जाप माला (Jaap)",
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 15.sp)
                    )
                }

                // SHARE BUTTON
                OutlinedButton(
                    onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(
                                Intent.EXTRA_SUBJECT,
                                "श्री हनुमान चालीसा (Shri Hanuman Chalisa)"
                            )
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "॥ श्री हनुमान चालीसा ॥\n\nजय हनुमान ज्ञान गुन सागर। जय कपीस तिहुँ लोक उजागर॥\n\nहनुमान जी की असीम कृपा आप और आपके परिवार पर सदा बनी रहे। जय श्री राम!\n\n(Shared from Hanuman Chalisa App)"
                            )
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share Hanuman Chalisa"))
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .testTag("home_btn_share"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "शेयर करें (Share)",
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 15.sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Sacred footer blessing
            Text(
                text = "॥ जो सत बार पाठ कर कोई, छूटहि बंदि महा सुख होई ॥",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun BigMenuButton(
    titleHindi: String,
    titleEnglish: String,
    subtitle: String,
    icon: ImageVector,
    backgroundColor: Color,
    contentColor: Color,
    isOutlined: Boolean = false,
    borderColor: Color = Color.Transparent,
    testTag: String,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 72.dp)
            .testTag(testTag)
            .shadow(if (isOutlined) 2.dp else 6.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        color = backgroundColor,
        contentColor = contentColor,
        border = if (isOutlined) androidx.compose.foundation.BorderStroke(2.dp, borderColor) else null
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(contentColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = titleEnglish,
                    tint = contentColor,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = titleHindi,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = contentColor
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "• $titleEnglish",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = contentColor.copy(alpha = 0.85f)
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp
                    ),
                    color = contentColor.copy(alpha = 0.8f)
                )
            }

            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Navigate",
                tint = contentColor.copy(alpha = 0.7f),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
